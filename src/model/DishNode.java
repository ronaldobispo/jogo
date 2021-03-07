package model;

public class DishNode {
    private DishNode leftNode;
    private DishNode rightNode;
    private Dish dish;

    private boolean isMainRoot;

    public Dish getDish() {
        return dish;
    }

    public void setRightNode(DishNode rightNode) {
        this.rightNode = rightNode;
    }

    public DishNode getLeftNode() {
        return leftNode;
    }

    public DishNode getRightNode() {
        return rightNode;
    }

    public boolean isMainRoot() {
        return isMainRoot;
    }

    public DishNode(String pName) {
        dish = new Dish(pName,"");
        leftNode = null;
        rightNode = null;
        isMainRoot = true;
    }

    public DishNode(String pName, String pType, DishNode pRoot) {
        dish = new Dish(pName,pType);
        isMainRoot = false;
        SetParentNode(pRoot);
    }

    public void SetParentNode(DishNode pRoot) {
        if (pRoot == null) {
            return;
        }

        if (pRoot.leftNode == null) {
            pRoot.leftNode = this;
        }
        if (pRoot.isMainRoot() && pRoot.rightNode == null) {
            pRoot.rightNode = this;
        } else {
            DishNode right = pRoot.getLeftNode();
            while (right.getRightNode() != null) {
                right = right.getRightNode();
            }
            if (right != this) {
                right.setRightNode(this);
            }
        }
    }
}
