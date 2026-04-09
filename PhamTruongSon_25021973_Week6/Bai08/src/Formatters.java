class JsonFormatter implements ReportFormatter {
    @Override
    public String format(Report report) {
        return "{\n" +
               "  \"title\": \"" + report.getTitle() + "\",\n" +
               "  \"content\": \"" + report.getContent() + "\"\n" +
               "}";
    }
}

class XmlFormatter implements ReportFormatter {
    @Override
    public String format(Report report) {
        return "<report>\n" +
               "  <title>" + report.getTitle() + "</title>\n" +
               "  <content>" + report.getContent() + "</content>\n" +
               "</report>";
    }
}