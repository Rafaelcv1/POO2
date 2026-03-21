public class Account {

  private String name;

  public String getName() {
    return name;
  }

  public final void setName(String name) throws Exception {
    if (name == null) {
      throw new Exception("Null não é aceito");
    } else {
      this.name = name;
    }
  }

  public Account(String name) throws Exception {
    setName(name);
  }
}
