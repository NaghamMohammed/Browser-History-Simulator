public class BrowserHistory {

    private String currentPage;//الموقع الحالي الي انا فيه حاليا

    private  Stack backStack; //الموقع السابق الي زرتو قبل الموقع الحالي
    private Stack forwardStack;//الموقع الي رح اروح عليه بعد الموقع الحالي
    
    private  LinkedList history;//كل المواقع الي زرتها من اول ما فتحت المتصفح

    private  String[]  bookmark;//مصفوفة لتخزين المواقع المفضلة
    private int bookmarkCount;//متغير لتخزين عدد المواقع المفضلة الي خزنتها


    public BrowserHistory(){//كونستركتور الكلاس الي بعمل تهيئة للمتغيرات
        currentPage="www.google.com";//الموقع الحالي الي انا فيه حاليا

        backStack = new Stack();//الموقع السابق الي زرتو قبل الموقع الحالي  فارغ كبداية
        forwardStack = new Stack();//الموقع الي رح اروح عليه بعد الموقع الحالي فارغ كبداية
        history = new LinkedList();//كل المواقع الي زرتها من اول ما فتحت المتصفح تكون فارغة كبداية

        bookmark = new String[5];   //مصفوفة لتخزين المواقع المفضلة فارغة كبداية
        bookmarkCount = 0;  //متغير لتخزين عدد المواقع المفضلة الي خزنتها كبداية صفر

        history.addLast(currentPage); //اضافة الموقع الحالي الى تاريخ التصفح كبداية
    }


    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public boolean visitWebsite(String url) {
        url = url.trim(); // إزالة المسافات الزائدة من الرابط

        if (url.isEmpty() || url.contains(" ")) { // التحقق من صحة الرابط
            System.out.println("Invalid URL.");
            return false;
        }
        if (url.equalsIgnoreCase(currentPage)) { // التحقق مما إذا كان الرابط هو نفسه الموقع الحالي مع غض النظر عن حالة الأحرف
            System.out.println("This website is already open.");
            return false;
        }

        backStack.push(currentPage); // إضافة الموقع الحالي إلى باك ستاك قبل الانتقال إلى الموقع الجديد  
        currentPage = url; // تحديث الموقع الحالي إلى الرابط الجديد
        history.addLast(currentPage); // إضافة الموقع الجديد إلى هيستوري 
        forwardStack = new Stack(); //  تفريغ فورورد ستاك بعد الانتقال إلى موقع جديد
        System.out.println("Website visited successfully."); // طباعة رسالة نجاح الزيارة
        return true; // إرجاع true للإشارة إلى نجاح العملية
    }


    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void goBack() { // الانتقال إلى الموقع السابق

        if (backStack.isEmpty()) {
            System.out.println("No previous website.");
            return;
        }
        forwardStack.push(currentPage); // إضافة الموقع الحالي إلى فورورد ستاك قبل الانتقال إلى الموقع السابق
        currentPage = backStack.pop();  //  تحديث الموقع الحالي إلى الموقع السابق من باك ستاك و حذف الموقع السابق من باك ستاك
        System.out.println("Returned to: " + currentPage);  // طباعة رسالة توضح الموقع الحالي بعد العودة
    }
    


    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void goForward() { // الانتقال إلى الموقع التالي

    if (forwardStack.isEmpty()) {
        System.out.println("No forward website.");
        return;
    }
    backStack.push(currentPage); // إضافة الموقع الحالي إلى باك ستاك قبل الانتقال إلى الموقع التالي
    currentPage = forwardStack.pop(); // تحديث الموقع الحالي إلى الموقع التالي من فورورد ستاك و حذف الموقع التالي من فورورد ستاك
    System.out.println("Moved forward to: " + currentPage); // طباعة رسالة توضح الموقع الحالي بعد الانتقال للأمام
    }


    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public String getCurrentPage() { // الحصول على الموقع الحالي
        return currentPage;
    }


    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void displayHistory() { // عرض تاريخ التصفح
        System.out.println("Browsing History:");
        history.display(); // استدعاء ميثود عرض محتويات القائمة في كلاس LinkedList
        }


    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public int countHistory() { // الحصول على عدد المواقع في تاريخ التصفح
        return history.count(); // استدعاء ميثود العد في كلاس LinkedList
    }


    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void addBookmark() { // إضافة الموقع الحالي إلى المفضلة

    if (bookmarkCount == bookmark.length) { // التحقق مما إذا كانت المفضلة ممتلئة
        System.out.println("Bookmarks are full.");
        return;
    }
    for (int i = 0; i < bookmarkCount; i++) { //  نمر على العناصر الموجودة فقط في المفضلة للتحقق من وجود الموقع الحالي مسبقًا ولا نمر على المصفوفة كاملة  

        if (bookmark[i].equalsIgnoreCase(currentPage)) { // فحص من وجود الموقع الحالي في المفضلة مع غض النظر عن حالة الأحرف
            System.out.println("Website already bookmarked.");
            return;
        }
    }
    bookmark[bookmarkCount] = currentPage; // إضافة الموقع الحالي إلى المفضلة في المصفوفة
    bookmarkCount++;                       // زيادة عدد المواقع المفضلة بعد الإضافة
    System.out.println("Bookmark added successfully."); 
    }


    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void displayBookmarks() { // عرض المواقع المفضلة

        if (bookmarkCount == 0) {  // التحقق مما إذا كانت المفضلة فارغة
            System.out.println("No bookmarks available.");
            return;
        }

        System.out.println("\nBookmarks:"); // طباعة عنوان المفضلة

        for (int i = 0; i < bookmarkCount; i++) { // نمر على العناصر الموجودة فقط في المفضلة ولا نمر على المصفوفة كاملة
            System.out.println((i + 1) + ". " + bookmark[i]); // طباعة كل موقع مفضل مع رقمه في القائمة
        }
    }
}

