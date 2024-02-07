package hw2;

public class Stack
{
    private class Node
    {
        Coords data;
        Node nextNode;
    }

    Node top;

    public Stack()
    {
        this.top = null;
    }


    void push(Coords x)
    {
        Node temp = new Node();
        temp.data = x;
        temp.nextNode = top;
        top = temp;
    }

    public boolean isEmpty()
    {
        return this.top == null;
    }

    public Coords peek()
    {
        if (!isEmpty())
        {
            return top.data;
        }
        else
        {
            return null;
        }
    }

    public Coords peekSecond()
    {
        if (top != null && top.nextNode != null)
        {
            return top.nextNode.data;
        }
        else
        {
            return null;
        }
    }

    public void pop()
    {
        if (top == null)
        {
            return;
        }

        top = top.nextNode;
    }
}
