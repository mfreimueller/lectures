-- Microsoft SQL Server Syntax
-- Created for: E-Sports Tournament Management Platform
-- Target Database: SQL Server 2019+

DROP TABLE IF EXISTS "stream_viewership";
DROP TABLE IF EXISTS "sponsorships";
DROP TABLE IF EXISTS "sponsors";
DROP TABLE IF EXISTS "match_statistics";
DROP TABLE IF EXISTS "matches";
DROP TABLE IF EXISTS "tournament_teams";
DROP TABLE IF EXISTS "tournaments";
DROP TABLE IF EXISTS "team_memberships";
DROP TABLE IF EXISTS "players"
DROP TABLE IF EXISTS "teams";
DROP TABLE IF EXISTS "games";

-- ============================================
-- CORE ENTITIES
-- ============================================

-- Games table - different e-sports titles (League of Legends, CS:GO, Dota 2, etc.)
CREATE TABLE "games" (
    [game_id] INT PRIMARY KEY IDENTITY(1,1),
    [title] NVARCHAR(100) NOT NULL UNIQUE,
    [developer] NVARCHAR(150),
    [release_year] INT CHECK ([release_year] >= 2000 AND [release_year] <= YEAR(GETDATE())),
    [genre] NVARCHAR(50), -- MOBA, FPS, RTS, Fighting, etc.
    [active_status] BIT DEFAULT 1, -- Is the game still supported?
    [description] NVARCHAR(MAX)
);

-- Teams table - professional gaming organizations/clans
CREATE TABLE "teams" (
    [team_id] INT PRIMARY KEY IDENTITY(1,1),
    [team_name] NVARCHAR(100) NOT NULL UNIQUE,
    [founded_year] INT CHECK ([founded_year] >= 2000 AND [founded_year] <= YEAR(GETDATE())),
    [country] NVARCHAR(50) NOT NULL, -- Team's home country/region
    [team_logo_url] NVARCHAR(500),
    [total_wins] INT DEFAULT 0,
    [active_status] BIT DEFAULT 1
);

-- Players table - individual competitive gamers
CREATE TABLE "players" (
    [player_id] INT PRIMARY KEY IDENTITY(1,1),
    [first_name] NVARCHAR(50) NOT NULL,
    [last_name] NVARCHAR(50) NOT NULL,
    [gamertag] NVARCHAR(30) UNIQUE NOT NULL, -- In-game nickname
    [date_of_birth] DATE CHECK (DATEPART(YEAR, GETDATE()) - DATEPART(YEAR, [date_of_birth]) >= 16), -- Min age 16
    [nationality] NVARCHAR(50),
    [role] NVARCHAR(30) NOT NULL, -- Carry, Support, Mid, Jungle, etc. (varies by game)
    [join_date] DATE DEFAULT CAST(GETDATE() AS DATE)
);

-- Team membership - many-to-many relationship between players and teams
CREATE TABLE "team_memberships" (
    [membership_id] INT PRIMARY KEY IDENTITY(1,1),
    [player_id] INT NOT NULL,
    [team_id] INT NOT NULL,
    [joined_date] DATE DEFAULT CAST(GETDATE() AS DATE),
    [left_date] DATE NULL, -- NULL if currently on team
    [jersey_number] INT CHECK ([jersey_number] >= 1 AND [jersey_number] <= 99),
    
    FOREIGN KEY ([player_id]) REFERENCES "players"([player_id]),
    FOREIGN KEY ([team_id]) REFERENCES "teams"([team_id]),
    UNIQUE ([player_id], team_id, left_date) -- Player can only have one active membership per team
);

-- Tournaments table - organized competitive events (World Championship, Regional Qualifiers, etc.)
CREATE TABLE "tournaments" (
    [tournament_id] INT PRIMARY KEY IDENTITY(1,1),
    [name] NVARCHAR(150) NOT NULL,
    [game_id] INT NOT NULL,
    [start_date] DATE NOT NULL,
    [end_date] DATE NOT NULL ,
    [prize_pool_usd] DECIMAL(18,2), -- Total prize money in USD
    [location_city] NVARCHAR(100),
    [location_country] NVARCHAR(50),
    [tournament_type] NVARCHAR(30) NOT NULL, -- Championship, Qualifier, Invitational, Regular Season
    [format] NVARCHAR(33), -- Single Elimination, Double Elimination, Round Robin
    [status] NVARCHAR(20) DEFAULT 'upcoming' CHECK ([status] IN ('upcoming', 'ongoing', 'completed', 'cancelled')),
    
    FOREIGN KEY ([game_id]) REFERENCES "games"([game_id]),
    CHECK ([prize_pool_usd] >= 0 OR [prize_pool_usd] IS NULL) -- Some tournaments may have no prize pool
);

ALTER TABLE "tournaments" ADD CHECK ([end_date] >= [start_date]);

-- Teams in tournament - which teams participate in each event
CREATE TABLE "tournament_teams" (
    [tournament_team_id] INT PRIMARY KEY IDENTITY(1,1),
    [tournament_id] INT NOT NULL,
    [team_id] INT NOT NULL,
    [seed_number] INT CHECK ([seed_number] >= 1), -- Tournament seeding rank
    [group_name] NVARCHAR(20), -- Group stage identifier (Group A, B, C, etc.)
    
    FOREIGN KEY ([tournament_id]) REFERENCES "tournaments"([tournament_id]),
    FOREIGN KEY ([team_id]) REFERENCES "teams"([team_id]),
    UNIQUE ([tournament_id], [team_id])
);

-- Matches table - individual games played between teams in tournaments
CREATE TABLE "matches" (
    [match_id] INT PRIMARY KEY IDENTITY(1,1),
    [tournament_id] INT NOT NULL,
    [round_name] NVARCHAR(50) NOT NULL, -- Group Stage, Quarterfinals, Semifinals, Finals, etc.
    [scheduled_datetime] DATETIME2 NOT NULL,
    [match_status] NVARCHAR(30) DEFAULT 'upcoming' CHECK ([match_status] IN ('upcoming', 'in_progress', 'completed', 'cancelled')),
    [winner_team_id] INT, -- NULL if match not completed yet
    [loser_team_id] INT,
    
    FOREIGN KEY ([tournament_id]) REFERENCES "tournaments"([tournament_id]),
    FOREIGN KEY ([winner_team_id]) REFERENCES "teams"([team_id]),
    FOREIGN KEY ([loser_team_id]) REFERENCES "teams"([team_id]),
    CHECK (
        [match_status] = 'upcoming' AND [winner_team_id] IS NULL OR
        [match_status] IN ('in_progress', 'completed') AND [winner_team_id] IS NOT NULL
    ) -- Winner only set when match is in progress or completed
);

-- Match statistics - detailed performance data for each team in a match
CREATE TABLE "match_statistics" (
    [stat_id] INT PRIMARY KEY IDENTITY(1,1),
    [match_id] INT NOT NULL,
    [team_id] INT NOT NULL,
    -- Game-specific stats will vary by game type
    -- Common FPS/MOBA statistics:
    [kills] INT DEFAULT 0 CHECK ([kills] >= 0),
    [deaths] INT DEFAULT 0 CHECK ([deaths] >= 0),
    [assists] INT DEFAULT 0 CHECK ([assists] >= 0),
    -- Additional metrics (example for FPS games):
    [headshots] INT DEFAULT 0,
    -- For MOBA: damage dealt to structures, wards placed, etc. could be added here
    [first_blood] BIT DEFAULT 0, -- Did team get first kill?
    
    FOREIGN KEY ([match_id]) REFERENCES "matches"([match_id]),
    FOREIGN KEY ([team_id]) REFERENCES "teams"([team_id]),
    CHECK ([kills] >= [deaths] OR [deaths] = 0) -- Optional: winning team should have more kills (simplified rule)
);

-- Sponsors table - companies that fund tournaments or teams
CREATE TABLE "sponsors" (
    [sponsor_id] INT PRIMARY KEY IDENTITY(1,1),
    [company_name] NVARCHAR(150) NOT NULL UNIQUE,
    [industry_category] NVARCHAR(50), -- Gaming Hardware, Energy Drinks, Tech, Automotive, etc.
    [website_url] NVARCHAR(200),
    [contact_email] NVARCHAR(100),
    [founded_year] INT CHECK ([founded_year] >= 1800 AND [founded_year] <= YEAR(GETDATE()))
);

-- Sponsorships - which sponsors fund which tournaments or teams (many-to-many)
CREATE TABLE "sponsorships" (
    [sponsorship_id] INT PRIMARY KEY IDENTITY(1,1),
    [sponsor_id] INT NOT NULL,
    -- Either tournament OR team can be sponsored (use CHECK constraint)
    [tournament_id] INT NULL,
    [team_id] INT NULL,
    
    [contract_start_date] DATE NOT NULL,
    [contract_end_date] DATE NOT NULL,
    [annual_value_usd] DECIMAL(18,2) CHECK ([annual_value_usd] > 0), -- Sponsorship contract value
    
    FOREIGN KEY (sponsor_id) REFERENCES "sponsors"(sponsor_id),
    FOREIGN KEY (tournament_id) REFERENCES "tournaments"(tournament_id),
    FOREIGN KEY (team_id) REFERENCES "teams"(team_id),
    
    CHECK (
        ([tournament_id] IS NOT NULL AND [team_id] IS NULL) OR -- Sponsored tournament only
        ([tournament_id] IS NULL AND [team_id] IS NOT NULL)     -- Sponsored team only
    ) -- Can't sponsor both at once in this model
);

ALTER TABLE "sponsorships" ADD CHECK ([contract_end_date] >= [contract_start_date]);

-- Stream viewership analytics - track audience during matches (for revenue calculation)
CREATE TABLE "stream_viewership" (
    [viewership_id] INT PRIMARY KEY IDENTITY(1,1),
    [match_id] INT NOT NULL,
    [peak_concurrent_viewers] INT CHECK ([peak_concurrent_viewers] >= 0), -- Highest simultaneous viewers
    [average_viewers] DECIMAL(10,2) CHECK ([average_viewers] >= 0), -- Average concurrent during match
    [total_hours_watched] DECIMAL(15,2) CHECK ([total_hours_watched] >= 0),
    [stream_platform] NVARCHAR(30) NOT NULL, -- Twitch, YouTube Gaming, Steam.tv, etc.
    [viewership_date] DATETIME2 DEFAULT GETDATE(),
    
    FOREIGN KEY ([match_id]) REFERENCES "matches"([match_id]),
    CHECK ([stream_platform] IN ('Twitch', 'YouTube Gaming', 'Steam.tv', 'Facebook Gaming'))
);

-- ============================================
-- INDEXES FOR QUERY PERFORMANCE OPTIMIZATION
-- ============================================

CREATE NONCLUSTERED INDEX [IX_teams_country] ON teams(country ASC) WHERE active_status = 1;
CREATE NONCLUSTERED INDEX [IX_players_gamertag] ON players(gamertag ASC);
CREATE NONCLUSTERED INDEX [IX_tournaments_game_date] ON tournaments(game_id, start_date DESC);
CREATE NONCLUSTERED INDEX [IX_matches_tournament_status] ON matches(tournament_id, match_status) INCLUDE (winner_team_id, loser_team_id);

-- ============================================
-- PHASE 1: GAMES (No dependencies)
-- ============================================

INSERT INTO games ([title], [developer], [release_year], [genre], [active_status], [description]) VALUES 
('League of Legends', 'Riot Games', 2009, 'MOBA', 1, 'Strategic team-based multiplayer online battle arena'),
('Counter-Strike: Global Offensive', 'Valve Corporation', 2012, 'FPS', 1, 'Tactical first-person shooter with competitive ranking system'),
('Dota 2', 'Valve Corporation', 2013, 'MOBA', 1, 'Complex strategy game with deep mechanics and high skill ceiling'),
('Valorant', 'Riot Games', 2020, 'FPS', 1, 'Character-based tactical shooter combining aim and ability usage'),
('Rocket League', 'Psyonix', 2015, 'Sports', 1, 'Vehicular soccer game with physics-based gameplay');

-- ============================================
-- PHASE 2: TEAMS (No dependencies)
-- ============================================

INSERT INTO teams ([team_name], [founded_year], [country], [team_logo_url], [total_wins], [active_status]) VALUES 
('Team Liquid', 2000, 'Netherlands', '/logos/team_liquid.png', 156, 1),
('Fnatic', 2004, 'United Kingdom', '/logos/fnatic.png', 203, 1),
('G2 Esports', 2017, 'Germany', '/logos/g2_esports.png', 89, 1),
('T1 (formerly SK Telecom T1)', 2003, 'South Korea', '/logos/t1.png', 342, 1),
('Cloud9', 2013, 'United States', '/logos/cloud9.png', 78, 1),
('FaZe Clan', 2010, 'United States', '/logos/faze_clan.png', 67, 1),
('NAVI (Natus Vincere)', 2009, 'Ukraine', '/logos/navi.png', 134, 1);

-- ============================================
-- PHASE 3: PLAYERS (No dependencies)
-- ============================================

INSERT INTO players ([first_name], [last_name], [gamertag], [date_of_birth], [nationality], [role]) VALUES 
('Rasmus', 'Winther', 'Caps', '1999-04-17', 'Denmark', 'Mid'),
('Marcin', 'Jankowski', 'Jankos', '1995-08-26', 'Poland', 'Jungle'),
('Finn', 'Andersen', 'Hans Sama', '2000-07-23', 'France', 'Carry'),
('Son', 'Ho-jin', 'Faker', '1996-05-08', 'South Korea', 'Mid'),
('Lee', 'Sang-hyeok', 'Keria', '2002-10-14', 'South Korea', 'Support'),
('Oscar', 'Canellas', 'Xerxe', '1996-03-07', 'France', 'Jungle'),
('Marek', 'Brázda', 'Humanoid', '1998-05-24', 'Czech Republic', 'Mid'),
('Oleksandr', 'Kostyliev', 's1mple', '1997-10-02', 'Ukraine', 'AWP'),
('Nikola', 'Kovač', 'NiKo', '1997-04-16', 'Bosnia and Herzegovina', 'Rifler'),
('Keith', 'Markovic', 'dev1ce', '1995-08-23', 'Denmark', 'Lurker');

-- ============================================
-- PHASE 4: TEAM MEMBERSHIPS (Depends on players & teams)
-- ============================================

INSERT INTO team_memberships ([player_id], [team_id], [joined_date], [left_date], [jersey_number]) VALUES 
(1, 2, '2018-11-27', NULL, 3), -- Caps joined Fnatic (now G2)
(2, 2, '2016-11-20', '2019-11-15', 4), -- Jankos left team in 2019
(1, 5, '2018-11-27', NULL, 3), -- Caps now with G2 (same as above)
(3, 6, '2020-01-15', NULL, 7), -- Hansama joined FaZe
(4, 7, '2013-02-09', NULL, 1), -- Faker legendary player with T1 since beginning
(5, 7, '2020-11-28', NULL, 6), -- Keria current T1 support
(6, 1, '2014-03-15', '2016-05-20', 5), -- Xerxe played for Team Liquid briefly then left
(7, 1, '2021-11-29', NULL, 8), -- Humanoid joined T1 organization (different from SKT)
(8, 4, '2016-06-01', NULL, 2), -- s1mple is NAVI's star player
(9, 3, '2015-09-10', NULL, 10); -- NiKo plays for G2 Esports

-- ============================================
-- PHASE 5: TOURNAMENTS (Depends on games)
-- ============================================

INSERT INTO tournaments ([name], [game_id], [start_date], [end_date], [prize_pool_usd], [location_city], [location_country], [tournament_type], [format], [status]) VALUES 
('League of Legends World Championship 2023', 1, '2023-10-10', '2023-11-19', 2250000.00, 'Seoul', 'South Korea', 'Championship', 'Double Elimination', 'completed'),
('The International Dota 2 Championship 2023', 3, '2023-10-12', '2023-10-29', 3000000.00, 'Seattle', 'United States', 'Championship', 'Group Stage + Single Elimination', 'completed'),
('CS:GO Major Copenhagen 2024', 2, '2024-03-17', '2024-03-31', 1250000.00, 'Copenhagen', 'Denmark', 'Major Championship', 'Swiss System + Single Elimination', 'completed'),
('Valorant Champions Tour 2024 Final', 4, '2024-08-01', '2024-08-18', 2500000.00, 'Los Angeles', 'United States', 'Championship', 'Double Elimination', 'completed'),
('Rocket League World Championship 2023', 5, '2023-07-26', '2023-08-06', 400000.00, 'London', 'United Kingdom', 'Championship', 'Double Elimination', 'completed'),
('League of Legends Mid-Season Invitational 2024', 1, '2024-05-01', '2024-05-19', 800000.00, 'Busan', 'South Korea', 'Regional Championship', 'Group Stage + Knockout', 'completed'),
('DreamHack Masters Winter 2024', 2, '2024-11-13', '2024-11-24', 500000.00, 'Stockholm', 'Sweden', 'Invitational', 'Round Robin + Playoffs', 'ongoing'),
('ESL Pro League Season 20', 3, '2024-12-04', '2024-12-15', 750000.00, 'Malta', 'Malta', 'Regular Season', 'Group Stage + Playoffs', 'upcoming');

-- ============================================
-- PHASE 6: TOURNAMENT TEAMS (Depends on tournaments & teams)
-- ============================================

INSERT INTO tournament_teams ([tournament_id], [team_id], [seed_number], [group_name]) VALUES 
(1, 7, 1, NULL), -- T1 seeded #1 in Worlds 2023
(1, 5, 2, 'Group A'), -- Cloud9 in Group A
(1, 2, 3, 'Group B'), -- Fnatic in Group B
(1, 6, 4, 'Group C'), -- FaZe Clan in Group C (if they qualify for LoL)
(2, 1, 1, NULL), -- Team Liquid seeded #1 TI 2023
(2, 4, 2, 'Upper Bracket'), -- T1 upper bracket
(3, 7, 1, NULL), -- NAVI top seed CS:GO Major
(3, 3, 2, 'Group A'), -- NiKo's team in Group A
(4, 5, 1, NULL), -- Cloud9 Valorant #1 seed
(7, 6, 3, 'Group B'); -- FaZe Clan DreamHack Winter

-- ============================================
-- PHASE 7: MATCHES (Depends on tournaments & teams)
-- ============================================

INSERT INTO matches ([tournament_id], [round_name], [scheduled_datetime], [match_status], [winner_team_id], [loser_team_id]) VALUES 
(1, 'Group Stage', '2023-10-10 14:00:00', 'completed', 7, 5), -- T1 vs Cloud9
(1, 'Group Stage', '2023-10-10 16:00:00', 'completed', 2, 6), -- Fnatic vs FaZe Clan
(1, 'Quarterfinals', '2023-10-28 14:00:00', 'completed', 7, NULL), -- T1 advanced (bye)
(1, 'Semifinals', '2023-11-05 16:00:00', 'completed', 2, 7), -- Fnatic beat T1 in semis!
(1, 'Grand Finals', '2023-11-19 18:00:00', 'completed', 2, 5), -- Fnatic won Worlds 2023 vs Cloud9
(2, 'Upper Bracket Round 1', '2023-10-14 12:00:00', 'completed', 1, 6), -- Team Liquid beat FaZe Clan
(3, 'Group Stage Match A', '2024-03-17 15:00:00', 'completed', 3, 4), -- NAVI vs NiKo's team
(3, 'Semifinals', '2024-03-29 16:00:00', 'upcoming', NULL, 6); -- NAVI lost semifinal (winner TBD)
-- Note: Using NULL for winner in incomplete match scenario

-- ============================================
-- PHASE 8: MATCH STATISTICS (Depends on matches & teams)
-- ============================================

INSERT INTO match_statistics ([match_id], [team_id], [kills], [deaths], [assists], [headshots], [first_blood]) VALUES 
(1, 7, 25, 18, 62, NULL, 1), -- T1 stats in Worlds Group Stage
(1, 5, 18, 15, 43, NULL, 0), -- Cloud9 stats (lost match)
(2, 2, 22, 15, 55, NULL, 0), -- Fnatic won against FaZe Clan
(2, 6, 23, 22, 38, NULL, 1), -- FaZe Clan stats (got first blood but lost)
(4, 2, 28, 20, 71, NULL, 1), -- Fnatic vs T1 Semifinals - close match!
(4, 7, 20, 18, 56, NULL, 0), 
(5, 2, 32, 19, 82, NULL, 0), -- Grand Finals: Fnatic dominated Cloud9
(5, 5, 19, 12, 47, NULL, 1), 
(6, 1, 45, 38, 92, 18, 1), -- CS:GO match stats (higher kill counts typical for FPS)
(6, 6, 38, 35, 76, 14, 0), 
(7, 3, 35, 30, 68, 22, 1), -- NAVI CS:GO Major performance
(7, 4, 30, 25, 55, 16, 0);

-- ============================================
-- PHASE 9: SPONSORS (No dependencies)
-- ============================================

INSERT INTO sponsors ([company_name], [industry_category], [website_url], [contact_email], [founded_year]) VALUES 
('Red Bull', 'Energy Drinks', 'https://www.redbull.com/esports', 'esports@redbull.com', 1987),
('Logitech G', 'Gaming Hardware', 'https://pro.logitech.com/en-us/gaming.html', 'partnerships@logitech.com', 2005),
('BMW M Motorsport', 'Automotive', 'https://www.bmw-m.com/motorsport/esports.html', 'esports@bmw.com', 1972),
('Intel Corporation', 'Technology Hardware', 'https://www.intel.com/gaming', 'gaming-partnerships@intel.com', 1968),
('Monster Energy', 'Energy Drinks', 'https://www.monsterenergy.com/esports', 'sponsors@monsterenergy.com', 2002);

-- ============================================
-- PHASE 10: SPONSORSHIPS (Depends on sponsors, tournaments & teams)
-- ============================================

INSERT INTO sponsorships ([sponsor_id], [tournament_id], [team_id], [contract_start_date], [contract_end_date], [annual_value_usd]) VALUES 
(1, NULL, 7, '2023-01-01', '2025-12-31', 850000.00), -- Red Bull sponsors T1 team
(2, NULL, 2, '2024-01-01', '2026-12-31', 750000.00), -- Logitech G sponsors Fnatic
(3, 8, NULL, '2024-12-01', '2025-12-31', 500000.00), -- BMW M sponsors ESL Pro League tournament
(4, NULL, 1, '2023-06-01', '2025-06-01', 900000.00), -- Intel sponsors Team Liquid team
(5, 7, NULL, '2024-11-01', '2025-03-31', 300000.00); -- Monster Energy sponsors DreamHack Winter tournament

-- ============================================
-- PHASE 11: STREAM VIEWERSHIP (Depends on matches)
-- ============================================

INSERT INTO stream_viewership ([match_id], [peak_concurrent_viewers], [average_viewers], [total_hours_watched], [stream_platform]) VALUES 
(1, 2500000.00, 1800000.00, 45000000.00, 'Twitch'), -- Worlds 2023 Group Stage - huge viewership!
(5, 6800000.00, 4200000.00, 120000000.00, 'Twitch'), -- Grand Finals: record-breaking numbers!
(7, 1200000.00, 850000.00, 18000000.00, 'Twitch'), -- CS:GO Major viewership
(4, 3500000.00, 2100000.00, 65000000.00, 'YouTube Gaming'); -- Valorant Champions Tour

-- ============================================
-- ADDITIONAL DATA FOR REALISTIC QUERY SCENARIOS
-- ============================================

-- More matches to create realistic tournament scenarios with multiple games per team
INSERT INTO matches ([tournament_id], [round_name], [scheduled_datetime], [match_status], [winner_team_id], [loser_team_id]) VALUES 
(1, 'Group Stage', '2023-10-12 14:00:00', 'completed', 5, NULL), -- Cloud9 vs Fnatic
(1, 'Quarterfinals', '2023-10-27 16:00:00', 'completed', 5, 2), -- Cloud9 eliminated T1!
(2, 'Lower Bracket Round 1', '2023-10-20 14:00:00', 'upcoming', NULL, 1); -- Team Liquid lost

-- More match statistics for these additional matches
INSERT INTO match_statistics ([match_id], [team_id], [kills], [deaths], [assists], [headshots]) VALUES 
(9, 5, 24, 20, 68, NULL), -- Cloud9 vs Fnatic stats
(9, 2, 25, 24, 51, NULL), 
(10, 5, 30, 22, 75, NULL), -- Cloud9 eliminated T1
(10, 7, 32, 30, 58, NULL);

-- Additional viewership data for more matches
INSERT INTO stream_viewership ([match_id], [peak_concurrent_viewers], [average_viewers], [total_hours_watched], [stream_platform]) VALUES 
(9, 3200000.00, 2400000.00, 78000000.00, 'Twitch'),
(10, 5100000.00, 3600000.00, 95000000.00, 'Twitch');

-- More sponsorships for realistic business scenarios
INSERT INTO sponsorships ([sponsor_id], [team_id], [contract_start_date], [contract_end_date], [annual_value_usd]) VALUES 
(2, 7, '2023-01-01', '2025-12-31', 650000.00), -- Logitech G also sponsors T1
(4, 6, '2024-01-01', '2027-12-31', 1200000.00); -- Intel long-term deal with NAVI

-- More players for larger rosters and team diversity
INSERT INTO players ([first_name], [last_name], [gamertag], [date_of_birth], [nationality], [role]) VALUES 
('Mads', 'Bjerre', 'Magnus', '1996-08-24', 'Denmark', 'Support'),
('Elias', 'Lipp', 'Jabbi', '2003-05-17', 'Germany', 'Carry'),
('Mathias', 'Schrøder', 'Crownless', '1998-06-24', 'Denmark', 'Support');

INSERT INTO team_memberships ([player_id], [team_id], [joined_date], [left_date], [jersey_number]) VALUES 
(11, 2, '2023-11-27', NULL, 5), -- Magnus joined Fnatic
(12, 6, '2024-01-15', NULL, 9), -- Jabbi with FaZe Clan
(13, 5, '2024-11-28', NULL, 7); -- Crownless joined Cloud9

-- More tournament data for complex query scenarios
INSERT INTO tournaments ([name], [game_id], [start_date], [end_date], [prize_pool_usd], [location_city], [location_country], [tournament_type], [format]) VALUES 
('League of Legends European Championship Spring 2024', 1, '2024-01-13', '2024-04-14', 600000.00, 'Berlin', 'Germany', 'Regional Championship', 'Regular Season + Playoffs'),
('Valorant EMEA Ascension 2024', 4, '2024-02-15', '2024-03-17', 200000.00, 'Budapest', 'Hungary', 'Qualifier', 'Single Elimination');

INSERT INTO tournament_teams ([tournament_id], [team_id], [seed_number], [group_name]) VALUES 
(9, 2, 1, NULL), -- Fnatic top seed in LEC Spring
(9, 5, 3, NULL), -- Cloud9 seeded #3
(10, 6, 2, 'Upper Bracket'); -- FaZe Clan Valorant qualifier

-- More matches for these tournaments
INSERT INTO matches ([tournament_id], [round_name], [scheduled_datetime], [match_status], [winner_team_id], [loser_team_id]) VALUES 
(9, 'Regular Season Week 1', '2024-01-13 17:00:00', 'completed', 2, 5), -- Fnatic beat Cloud9
(9, 'Playoffs Semifinals', '2024-04-06 18:00:00', 'upcoming', NULL, 2); -- Fnatic advanced (winner TBD)

INSERT INTO match_statistics ([match_id], [team_id], [kills], [deaths], [assists]) VALUES 
(13, 2, 27, 19, 65),
(13, 5, 29, 27, 48);

INSERT INTO stream_viewership ([match_id], [peak_concurrent_viewers], [average_viewers], [total_hours_watched], [stream_platform]) VALUES 
(13, 1800000.00, 1300000.00, 35000000.00, 'Youtube Gaming');

-- ============================================
-- VALIDATION: Verify all foreign keys are satisfied
-- All INSERT statements above should execute without FK constraint violations
-- ============================================
