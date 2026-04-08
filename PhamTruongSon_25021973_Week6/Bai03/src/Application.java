
class Application {

    private Button button;
    private Checkbox checkbox;

    // Client chỉ làm việc với các Interface (UIFactory, Button, Checkbox)
    public Application(UIFactory factory) {
        button = factory.createButton();
        checkbox = factory.createCheckbox();
    }

    public void paint() {
        button.render();
        checkbox.render();
    }
}
