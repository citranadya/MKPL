package tugasbab05;

public class SingleLinkedList {

    public Node pointer;

    public SingleLinkedList() { //constructor
        pointer = null;
    }

    public Node getPointer() {
        return pointer;
    }

    public void buatNode(int dt) { //node baru
        Node nodeBaru = new Node();
        nodeBaru.data = dt;
        nodeBaru.next = pointer;
        pointer = nodeBaru;
    }

    public int hapusDiDepan() { //hapus data di depan
        Node hapus = pointer;
        pointer = pointer.next;
        return hapus.data;
    }

    public void hapusData(int dataHapus) {
        Node n = pointer;
        while (n.next != null) {
            if (n.next.data == dataHapus) {
                Node hapus = n.next;
                n.next = hapus.next;
                hapus = null;
                break;

            }
            n = n.next;
        }
    }

    public void sisipDataUrut(int data) {
        buatNode(data);
        Node a = pointer;
        while (a != null) {
            Node b = a.next;
            while (b != null) {
                if (a.data < b.data) {
                    int tempt = a.data;
                    a.data = b.data;
                    b.data = tempt;
                    break;
                }
                b = b.next;
            }
            a = a.next;

        }

    }

    public void sisipDataDiAkhir(int data) {
        Node a, b;
        a = null;
        b = pointer;
        Node baru = new Node();
        baru.data = data;
        baru.next = null;
        while (b != null) {
            a = b;
            b = b.next;
        }
        a.next = baru;
    }

    public void cetak(String kom) { //cetak
        System.out.println(kom);
        Node n = pointer;
        while (n != null) {
            System.out.print(n.data + " -> ");
            n = n.next;
        }
        System.out.println("NULL");
    }

    public static SingleLinkedList gabung(SingleLinkedList L1, SingleLinkedList L2) {
        Node a = L2.getPointer();
        while (a != null) {
            L1.sisipDataDiAkhir(a.data);
            a = a.next;

        }
        return L1;

    }

}
