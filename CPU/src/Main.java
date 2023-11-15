import java.text.NumberFormat;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        // buat object CPU
        CPU myKomputer = new CPU(15000000, "Lenovo");

        CPU.Processor i7 = myKomputer.new Processor(8, "Intel", "i7");

        CPU.RAM rs32GB = myKomputer.new RAM(32, "Samsung");

        myKomputer.getCPUInfo();
        i7.getProcessorInfo();
        rs32GB.getInfoRAM();

        // bikin object harddisk, vga, motherboard, powersupply
        CPU.Harddisk hd = myKomputer.new Harddisk(1000, "Seagate");
        CPU.VGACard vga = myKomputer.new VGACard("NVIDIA", "GTX 1080");
        CPU.Motherboard motherboard = myKomputer.new Motherboard("ASUS", "ATX");
        CPU.PowerSupply powerSupply = myKomputer.new PowerSupply("Corsair", 750);

        hd.getHarddiskInfo();
        vga.getVGACardInfo();
        motherboard.getMotherboardInfo();
        powerSupply.getPowerSupplyInfo();
    }
}

class CPU {
    private double harga;
    private String merek;

    public CPU(double harga, String merek) {
        this.harga = harga;
        this.merek = merek;
    }

    public class Processor {
        int cores;
        String manufacturer;
        String name;

        Processor(int cores, String manufacturer, String name) {
            this.cores = cores;
            this.manufacturer = manufacturer;
            this.name = name;
        }

        public void getProcessorInfo() {
            System.out.println("Jumlah core: " + this.cores);
            System.out.println("Pabrik: " + this.manufacturer);
            System.out.println("Processor: " + this.name);
        }
    }

    public class RAM {
        int jumlahRAM;
        String manufacturer;

        RAM(int jumlahRAM, String manufacturer) {
            this.jumlahRAM = jumlahRAM;
            this.manufacturer = manufacturer;
        }

        public void getInfoRAM() {
            System.out.println("Jumlah RAM: " + this.jumlahRAM);
            System.out.println("Pabrik: " + this.manufacturer);
        }
    }

    public class Harddisk {
        double capacity;
        String manufacturer;

        Harddisk(double capacity, String manufacturer) {
            this.capacity = capacity;
            this.manufacturer = manufacturer;
        }

        public void getHarddiskInfo() {
            System.out.println("Kapasitas Harddisk: " + this.capacity + " GB");
            System.out.println("Pabrik: " + this.manufacturer);
        }
    }

    public class VGACard {
        String manufacturer;
        String model;

        VGACard(String manufacturer, String model) {
            this.manufacturer = manufacturer;
            this.model = model;
        }

        public void getVGACardInfo() {
            System.out.println("Pabrik VGA Card: " + this.manufacturer);
            System.out.println("Model: " + this.model);
        }
    }

    public class Motherboard {
        String manufacturer;
        String type;

        Motherboard(String manufacturer, String type) {
            this.manufacturer = manufacturer;
            this.type = type;
        }

        public void getMotherboardInfo() {
            System.out.println("Pabrik Motherboard: " + this.manufacturer);
            System.out.println("Tipe: " + this.type);
        }
    }

    public class PowerSupply {
        String manufacturer;
        int wattage;

        PowerSupply(String manufacturer, int wattage) {
            this.manufacturer = manufacturer;
            this.wattage = wattage;
        }

        public void getPowerSupplyInfo() {
            System.out.println("Pabrik Power Supply: " + this.manufacturer);
            System.out.println("Daya: " + this.wattage + " Watt");
        }
    }

    public void getCPUInfo() {
        Locale localeID = new Locale("in", "ID");
        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);

        System.out.println("Komputer Merek: " + this.merek);

        // menuliskan harga yang double ke dalam format rupiah
        System.out.println("Harga: " + formatRupiah.format(this.harga));
    }
}
