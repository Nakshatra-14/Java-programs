
public void insertAfterLast(int data)
{
    Node node = new Node(data);

    if(first == null)
        first = node;
    else
    {
        Node temp = first;
        while(temp.next != null)
        {
            temp = temp.next;
        }
        temp.new = node;
    }
}

