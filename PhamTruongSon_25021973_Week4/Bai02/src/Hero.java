
public class Hero extends ActionCharacter implements CanFight, CanFly, CanSwim {

    @Override
    public void swim() {
        System.out.println("Hero is swimming....");
    }

    // @Override
    // public void fight(){
    //     System.out.println("Hero is fighting ....");
    // }
    // Không cần implement fight vì ActionCharacter đã có sẵn.
    @Override
    public void fly() {
        System.out.println("Hero is flying ....");
    }
}
