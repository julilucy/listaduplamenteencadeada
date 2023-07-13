package listadupla;
import java.util.Scanner;


public class DoublyLinkedList {
    private Node head;
    private Node tail;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void insertAtHead(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.setNext(head);
            head.setPrev(newNode);
            head = newNode;
        }
    }

    public void insertAtTail(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setPrev(tail);
            tail = newNode;
        }
    }

    public void deleteAtHead() {
        if (!isEmpty()) {
            head = head.getNext();
            if (head != null) {
                head.setPrev(null);
            } else {
                tail = null;
            }
        }
    }

    public void deleteAtTail() {
        if (!isEmpty()) {
            tail = tail.getPrev();
            if (tail != null) {
                tail.setNext(null);
            } else {
                head = null;
            }
        }
    }

    public void display() {
        Node current = head;
        System.out.print("Lista: ");
        while (current != null) {
            System.out.print(current.getData() + " ");
            current = current.getNext();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Digite '1' para inserir um elemento na lista");
            System.out.println("Digite '2' para remover um elemento da lista");
            System.out.println("Digite '3' para exibir a lista");
            System.out.println("Digite '0' para sair");

            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.println("Digite o elemento a ser inserido: ");
                int element = scanner.nextInt();
                list.insertAtTail(element);
            } else if (choice == 2) {
                if (list.isEmpty()) {
                    System.out.println("A lista está vazia. Nenhum elemento para remover.");
                } else {
                    System.out.println("Digite o elemento a ser removido: ");
                    int element = scanner.nextInt();
                    if (list.head.getData() == element) {
                        list.deleteAtHead();
                    } else if (list.tail.getData() == element) {
                        list.deleteAtTail();
                    } else {
                        Node current = list.head.getNext();
                        boolean found = false;
                        while (current != null) {
                            if (current.getData() == element) {
                                current.getPrev().setNext(current.getNext());
                                current.getNext().setPrev(current.getPrev());
                                found = true;
                                break;
                            }
                            current = current.getNext();
                        }
                        if (!found) {
                            System.out.println("Elemento não encontrado na lista.");
                        }
                    }
                }
            } else if (choice == 3) {
                list.display();
            } else if (choice == 0) {
                break;
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }

            System.out.println();
        }

        scanner.close();
    }
}





