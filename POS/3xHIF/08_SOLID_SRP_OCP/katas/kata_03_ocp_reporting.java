class ReportGenerator {
    String generateText(String title, String content) {
        return "=== " + title + " ===\n" + content;
    }

    public static void main(String[] args) {
        ReportGenerator gen = new ReportGenerator();
        System.out.println("Text format:");
        System.out.println(gen.generateText("Sales Report", "Q1 revenue increased by 20%"));
    }
}
