public interface SetInterface<T> {
/**
    * method name getCurrentSize
    * pre condition None 
    * post condition None
    */
    
    public int getCurrentSize();
    
    /**
    * method name Add
    * pre condition None 
    * post condition None
    */
    
    public boolean add(T item);
    /**
    * method name Remove
    * pre condition None 
    * post condition None
    */
    
    public T remove();
    /**
    * method name Remove
    * pre condition None 
    * post condition None
    */
    
    public boolean remove(T item);
   /**
    * method name Contains
    * pre condition None 
    * post condition None
    */
    
    public boolean contains(T item);
    
    /**
    * method name getReferneceOf
    * pre condition None 
    * post condition None
    */
    
    public int getFrequencyOf(T item);
    /**
    * method name toArr
    * pre condition None 
    * post condition None
    */
    
    public T[] toArr();
    /**
    * method name union
    * pre condition None 
    * post condition None
    */
    
    public SetInterface<T> union(SetInterface<T> rhs);
    
    /**
    * method name union
    * pre condition None 
    * post condition None
    */
    
    public SetInterface<T> intersection(SetInterface<T> rhs);
    /**
    * method name difference
    * pre condition None 
    * post condition None
    */
    
    public SetInterface<T> difference(SetInterface<T> rhs);
}