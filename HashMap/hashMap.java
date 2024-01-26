 
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HashMap<K ,V>{
 
  private Node[] firstNodes;

  private int capacity;

  HashMap(){
    capacity = 16;
    firstNodes = new Node[capacity];
  }

  HashMap(int capacity){
     this.capacity = capacity;
     firstNodes = new Node[capacity];
  }

  void put(K newKey, V newValue){
     int hashIndex = newKey.hashCode()%capacity;
     if(firstNodes[hashIndex]==null){
      
        firstNodes[hashIndex] = new Node(newKey,newValue);
        return;
     }
     Node currentVal = firstNodes[hashIndex];
     do{
       if(currentVal.value.equals(newValue)){
          return;
       }
       else{
           if(currentVal.next==null){
              currentVal.next = new Node(newKey,newValue);
              break;
           }
           else
              currentVal = currentVal.next;
       }
     }
     while(true);
  }

  V get(K searchingKey){
     Node getting = firstNodes[searchingKey.hashCode()%capacity];
      if(getting==null){
         return null;
      }
      do{
        if(getting.key.equals(searchingKey)){
            return (V) getting.value;
        }
        else{
            if(getting.next==null){
               return null;
            }
            else{
               getting = getting.next;
            }
        }
     }
     while(true);
  }

  public Set<K> keySet(){
     Set<K> resultSet=new HashSet<>();
     for(Node value : firstNodes){
        if(value==null)
           continue;
        resultSet.add((K)value.key);
        while(value.next!=null){
            value = value.next;
            resultSet.add((K)value.key);
        }
    }
    return resultSet;
  }

  public List<Entry> entrySet() {
     List<Entry> list = new ArrayList<>();
     for(Node node : firstNodes){
        if(node==null)
           continue;
        list.add(new Entry<>((K) node.key, (V) node.value));
        while(node.next!=null){
             node = node.next;
             list.add(new Entry<>((K)node.key,(V) node.value));
        }
     }  
     return list;
  }
  
  V remove(K key){
     Node removingNode = firstNodes[key.hashCode()%capacity];
     if(removingNode==null){
       return null;
     }
     if(removingNode.key.equals(key)){
        firstNodes[key.hashCode()%capacity] = removingNode.next;
        return (V) removingNode.value;
     }
     while(true){
         if(removingNode.next==null){
            return null;
         }
         if(removingNode.next.key.equals(key)){
            V returningNodeValue = (V)removingNode.next.value;
            removingNode.next = removingNode.next.next;
             removingNode.next.next=null;
             return returningNodeValue;
         }
         else{
             removingNode = removingNode.next;
         }
     }
  }
  class Node<k,v>{
      K key;
      V value;
      Node next;

      Node(K key,V value){
        this.key = key;
        this.value = value;
        next = null;
      }
  }

  class Entry<k,v>{
      private K key;
      private V value;

      public Entry(K key, V value) {
          this.key = key;
          this.value = value;
      }

      public K getKey() {
          return key;
      }

      public V getValue() {
          return value;
      }

      @Override
      public String toString() {
          return"Entry{" +
                "key=" + key +
                ", value=" + value +
                "}\n";
      }
  }
  public static void main(String[] args){
    HashMap<Character, Integer> hash=new HashMap<>(5);
    hash.put('a',8);
    hash.put('b',5);
    hash.put('c',2);
    System.out.println(hash.entrySet());
  }
}