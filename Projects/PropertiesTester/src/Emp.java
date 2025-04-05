public class Emp {

    private String name;
    private int age;
    private float sal;
    static boolean nameChanege = false;

    Emp(String name, int age, float sal) {
        this.name = name;
        this.age = age;
        this.sal = sal;
    }

    

    public Property getNameProperty() {
        class NameProperty implements Property {

            @Override
            public String getName() {
                return "Name";
            }
    
            @Override
            public String getVal() {
                return name;
            }
    
            @Override
            public void setVal(String val) {
    
                name = val;
            }
    
        }
        return new NameProperty();
    }

    public Property getAgeProperty() {
        return new Property() {

            @Override
            public String getName() {
                return "Age";
            }
    
            @Override
            public String getVal() {
                return String.valueOf(age);
            }
    
            @Override
            public void setVal(String val) {
                age = Integer.parseInt(val);
            }
    
        };
    }

    
    public Property getSalProperty() {
        class SalProperty implements Property {

            @Override
            public String getName() {
                return "Salary";
            }
    
            @Override
            public String getVal() {
                return String.valueOf(sal);
            }
    
            @Override
            public void setVal(String val) {
                if (!nameChanege) {
                    sal = Float.parseFloat(val);
                    nameChanege = true;
                }
            }
    
        }
        return new SalProperty();
    }

    @Override
    public String toString() {
        return "Emp [name=" + name + ", age=" + age + ", sal=" + sal + "]";
    }
}
