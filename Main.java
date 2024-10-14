import java.util.Scanner;
public class Main {
    double real;
    double image;
    public Main(){
        this(0,0);
    }
    public Main(double real,double image){
        this.real = real;
        this.image = image;
    }
    public String toString(){
        return String.format("%.2f + %.2fi",real,image);
    }
    public void add(Main c){
        this.real += c.real;
        this.image += c.image;
    }
    public double abs(){
        return Math.sqrt(real*real +image*image);
    }
    public double arg(){
        return Math.atan(image/real);
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        Main[] mang = new Main[n];
        for(int i = 0;i<n;i++){
            double c,d;
            c = scan.nextDouble();
            d = scan.nextDouble();
            Main b = new Main(c,d);
            mang[i] = b;
        }
        scan.close();
        //Cau 2
        for(int i= 0;i<n;i++){
            for(int j = i+1;j<n;j++){
                if (mang[i].arg() > mang[j].arg()){
                    Main temp =new Main();
                    temp = mang[i];
                    mang[i] = mang[j];
                    mang[j] = temp;
                }
            }
        }
        
        for(int i = 0;i<n;i++){
            System.out.println(mang[i]);
        }
        //Cau 3
        double s= 0;
        for(int i = 0;i <n;i++){
            s += mang[i].abs();
        }
        double tong = 0;
        for(int i =0 ; i<n;i++){
            if(mang[i].abs() < s/n){
                tong += mang[i].abs();
            }
        }
        System.out.printf("%.2f",tong);
    }
}
// Xay dung mot lop Menu co chuc nang sau:
// 1. Them danh sach cac chuc nang de lua chon. Moi chuc nang gom co phan ten va mo ta cua chuc nang do
// 2. Xoa chuc nang trong danh sach
// 3. Chinh sua ten chuc nang
// 4. Hien thi Menu
// 5. Xac dinh chuc nang duoc chon (thuc thi mot chuc nang trong menu khi lua chon bang cach nhap so thu tu cua chac nang)


