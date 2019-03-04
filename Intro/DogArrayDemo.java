public class DogArrayDemo {
    public static void main(String[] args) {
        /* Create an array of two dogs. */
        Dog[] dogs = new Dog[2];
        dogs[0] = new Dog(8);
        dogs[1] = new Dog(20);

        Dog[] wolfDogs = new Dog[5];
        for (int i = 0; i < 5; i++) {
            wolfDogs[i] = new Dog(i * 23);
            wolfDogs[i].makeNoise();
        }

        /* Yipping will result, since dogs[0] has weight 8. */
        dogs[0].makeNoise();
    }
}