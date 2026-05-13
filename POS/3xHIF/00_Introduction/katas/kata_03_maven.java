public class Maven {
    public static void main(String[] args) throws Exception {
        var content = new String(
            Maven.class.getResourceAsStream("/text.txt").readAllBytes()
        );
        var count = StringUtils.wordCount(content);
        System.out.println("Word count: " + count);
    }
}
