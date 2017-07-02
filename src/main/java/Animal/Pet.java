package Animal;

/**
 * Created by Slavka Dontsov on 02.07.2017.
 */
public abstract class Pet {

    private final String id;
    private final String petName;

    public Pet(final String id, final String petName){
        this.id = id;
        this.petName = petName;
    }
}
