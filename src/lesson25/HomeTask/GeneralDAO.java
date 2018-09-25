package lesson25.HomeTask;

/**
 * Created by Valik on 24.09.2018.
 */
public class GeneralDAO<T>  {
    @SuppressWarnings("unchecked")
    T[] array = (T[]) new Object[10];

    public T save(T t) throws Exception {
        validate();

        int index = 0;
        for (T el : array) {
            if(el == null){
                array[index] = t;
                return array[index];
            }
            index++;
        }
        throw new Exception("Error. Can't be save.");
    }


    public T[] getAll(){
        int index = 0;
        int count = 0;
        for(T el : array){
            if(el != null)
                count++;
        }

        T[] array1 = (T[]) new Object[count];
        for(T el : array){
            if(el != null) {
                array1[index] = el;
                index++;
            }
        }
        return array1;
    }

    private void validate() throws Exception{
        int count = 0;
        for(T el : array){
            if(el != null)
                count++;
        }

        if(count >= array.length)
            throw new Exception("Array is max. Can't be save.");
    }
}
