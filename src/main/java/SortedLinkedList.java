import java.util.*;
import java.util.stream.*;

public class SortedLinkedList {

    private Uzel hlava = null;

    public void pridatUzel(int value) {
        Uzel novejUzel = new Uzel(value);
        if (hlava == null) {
            hlava = novejUzel;
            return;
        }
        novejUzel.setDalsi(hlava);
        hlava.setPredchozi(novejUzel);
        hlava = novejUzel;
        Uzel current = hlava;
        Uzel sorted = null;
        while (current != null) {
            Uzel currentDalsi = current.getDalsi();
            sorted = sort(sorted, current);
            current = currentDalsi;
        }
        hlava = sorted;
    }

    public void removeUzetAt(int pozice) {
        if (pozice == 0 || pozice > this.getListSize()) {
            System.out.println("Chybny index pro odstraneni uzlu");
        } else {
            Uzel temp = hlava;
            for (int i = 1; i < pozice - 1; i++) {
                temp = temp.getDalsi();
            }
            temp.setDalsi(temp.getDalsi().getDalsi());
        }
        this.getListSize();
    }

    public void pridatVice(List<Integer> values) {
        values.stream().forEach(this::pridatUzel);
    }

    private Uzel sort(Uzel srovnany, Uzel current) {
        if (srovnany == null || srovnany.getHodnota() >= current.getHodnota()) {
            current.setPredchozi(null);
            current.setDalsi(srovnany);
            if (srovnany != null) {
                srovnany.setPredchozi(current);
            }
            return current;
        } else {
            Uzel temp = srovnany;
            while (temp.getDalsi() != null && temp.getDalsi().getHodnota() < current.getHodnota()) {
                temp = temp.getDalsi();
            }
            current.setPredchozi(temp);
            current.setDalsi(temp.getDalsi());
            temp.setDalsi(current);
        }
        return srovnany;
    }

    public void printHodnoty() {
        Uzel temp = hlava;
        if (temp != null) {
            List<String> forPrint = new LinkedList<>();
            do {
                forPrint.add(String.valueOf(temp.getHodnota()));
                temp = temp.getDalsi();
            } while (temp != null);
            System.out.println(forPrint.stream().collect(Collectors.joining(", ")));
        } else {
            System.out.println("List je prazdny.");
        }
    }

    public int getListSize() {
        int count = 0;
        Uzel temp = hlava;
        if (temp != null) {
            do {
                count++;
                temp = temp.getDalsi();
            } while (temp != null);
        }
        return count;
    }

    public List<Integer> getHodnotyList() {
        List<Integer> r = new LinkedList<>();
        Uzel temp = hlava;
        if (temp != null) {
            do {
                r.add(temp.getHodnota());
                temp = temp.getDalsi();
            } while (temp != null);
        }
        return r;
    }

    public Uzel getHlava() {
        return hlava;
    }

}
