package view;

import helper.*;
import model.DishNode;
import javax.swing.*;

public class Game {
    private DishNode rootPasta;
    private DishNode rootCake;
    private DishNode root;

    public Game() {
        rootPasta = new DishNode("Lasanha");
        rootCake = new DishNode("Bolo de Chocolate");
        run();
    }

    private void run() {
        if (Utils.showMessage("Pense em um prato que gosta.", true, JOptionPane.PLAIN_MESSAGE) != 0)
            System.exit(1);

        if (isPasta()) {
            validateTree(rootPasta);
        } else {
            validateTree(rootCake);
        }

        run();
    }

    private void validateTree(DishNode pRoot) {
        root = pRoot;
        if (isRootValid(root) == false) {
            if (Utils.showConfirmMessage("O prato que voce pensou é " + root.getDish().getName() + "?")) {
                confirm();
            } else {
                createDish(root);
            }
        }
    }

    private boolean isRootValid(DishNode pNode) {
        if (pNode == null)
            return false;

        while (pNode != null) {
            if (isValidDishType(pNode) == false) {
                pNode = pNode.getRightNode();
            } else {
                root = pNode;
                pNode = pNode.getLeftNode();
                break;
            }
        }

        if (pNode == null) {
            return  false;
        } else {
            return isRootValid(pNode);
        }
    }

    private boolean isValidDishType(DishNode pDishNode) {
        if (pDishNode.getDish().getType() == "") {
            return false;
        }
        return Utils.showConfirmMessage("O prato que voce pensou é " + pDishNode.getDish().getType() + "?");
    }

    private DishNode createDish(DishNode pRootDish) {
        String dishName = Utils.showInputMessage("Qual prato você pensou?", "Desisto");
        String dishType = Utils.showInputMessage(dishName + " é mais _____ do que " + pRootDish.getDish().getName(), "Complete");

        return new DishNode(dishName, dishType, pRootDish);
    }

    private void confirm() {
        Utils.showMessage("Acertei de novo!", false, JOptionPane.INFORMATION_MESSAGE);
    }

    private boolean isPasta() {
        return Utils.showConfirmMessage("O prato que voce pensou é massa?");
    }
}
