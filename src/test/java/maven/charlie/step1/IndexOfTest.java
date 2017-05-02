package maven.charlie.step1;

public class IndexOfTest {

    public static void main(String[] args) {
        String s1 = "ERP ESB流水号:GERP-000000007754775>>>>收款编号:BMS2016030313,收款编号已存在>>ERP请求ID:>>BMS-cHmoFfza015048";
        System.out.println(s1.indexOf("收款编号已存在"));
    }
}
