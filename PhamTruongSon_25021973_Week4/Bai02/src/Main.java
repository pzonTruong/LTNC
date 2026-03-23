
public class Main {

    public static void main(String[] args) {
        Hero h = new Hero();
        CanSwim swimmer = (CanSwim) h;
        swimmer.swim();

        CanFight fighter = (CanFight) h;
        fighter.fight();
    }
}
