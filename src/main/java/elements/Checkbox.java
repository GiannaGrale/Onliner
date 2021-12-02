package elements;

@ImplementedBy(CheckBoxImpl.class)
public interface Checkbox extends Element{

     void clickCheckbox(boolean isChecked);
}
