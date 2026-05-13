# Kata 3: Roman Numerals

| Field | Value |
|-------|-------|
| Concepts | TDD, algorithm design, refactoring |
| Difficulty | 3/5 |
| Duration | approx. 25 min |

### Task

Use strict TDD to implement a method `String toRoman(int n)` that converts an integer (1-3999) to Roman numerals.

Roman numeral rules:
- I=1, V=5, X=10, L=50, C=100, D=500, M=1000
- Numbers are formed by combining symbols
- Subtractive notation: 4=IV, 9=IX, 40=XL, 90=XC, 400=CD, 900=CM

Write one test at a time, then make it pass, then refactor.

### Example Output

```
toRoman(1) -> "I"
toRoman(4) -> "IV"
toRoman(9) -> "IX"
toRoman(42) -> "XLII"
toRoman(1994) -> "MCMXCIV"
toRoman(2024) -> "MMXXIV"
```

### Extension

Add reverse conversion `int fromRoman(String roman)`.
