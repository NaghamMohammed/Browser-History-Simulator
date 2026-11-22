public class Node {

    private String url;  // متغير سيتم تخزين فيه رابط الموقع داخل كل نود 
    private Node next;   //  متغير من نوع نود يشير الى العقدة التالية لكل نود 
    // كونستركتور كلاس النود  الذي يهيئ النود ويعطيها عنوان الموقع ويكون مؤشر العقدةة التالية مبدئيا فارغ كبداية 
    public Node(String url){  
    this.url=url;
    this.next=null;
    }
    // العمليات والاشياء التي احتاجها من كلاس النود 
    // ميثود بترجع الرابط 
    public String getUrl(){
        return url;
    }
    // ميثود بتردع العقدة التالية 
    public Node getNext(){
        return next;
    }
    //ميثود بتحدد العقدة التالية 
    public void setNext(Node next){
        this.next=next;
    }
}