import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class ArithmeticTree {
  private class Node {
    private String content;
    private Node left;
    private Node right;

    public Node(String content) { this.content = content; }

    public boolean isOperator() { return !isNumber() && !isVariable(); }
    public boolean isNumber() { return content.matches("^([0-9](.[0-9])?)*$"); }
    public boolean isVariable() { return content.matches("^[a-zA-Z]*$"); }
  }

  String formula;
  Map<String, Double> variables;
  Node root;

  // private constructor: cannot be called outside of this class
  private ArithmeticTree() {
    formula = "";
    variables = new HashMap<>();
  }

  // creates the default arithmetic tree: "+ * a 2.1 - 3 b"
  public static ArithmeticTree createDefault() {
    return createFormula("+ * a 2.1 - 3 b");
  }

  // deserializes the string "s" and returns a new tree
  public static ArithmeticTree createFormula(String s) {
    var newObject = new ArithmeticTree();
    newObject.formula = s;
    newObject.parseFormulaToTree();

    return newObject;
  }

  // serializes tree into a string
  public String serialize() {
    return preOrderToString(root);
  }

  // defines a variable "var" with value "val"
  public void define(String var, double val) {
    if (variables.containsKey(var)) {
      variables.replace(var, val);
    } else {
      variables.put(var, val);
    }
  }

  // evaluates the tree
  public double evaluate() throws ScriptException {
    var inOrderFormula = inOrderToString(root);

    for (Map.Entry<String, Double> entry : variables.entrySet()) {
      inOrderFormula = inOrderFormula.replace(entry.getKey(), entry.getValue().toString());
    }

    var factory = new ScriptEngineManager();

    var engine = factory.getEngineByName("JavaScript");

    var obj = engine.eval(inOrderFormula);

    return Double.parseDouble(obj.toString());
  }

  private void parseFormulaToTree() {
    String[] elements = formula.split(" ");

    root = new Node(elements[0]);

    Stack<Node> stack = new Stack<>();
    stack.push(root);

    Node nodeElement;
    Node top;
    for (int i = 1; i < elements.length; i++) {
      nodeElement = new Node(elements[i]);

      top = stack.lastElement();

      if (top.isOperator()) {
        if (top.left == null) top.left = nodeElement;
        else top.right = nodeElement;

        if (nodeElement.isOperator()) stack.push(nodeElement);
      }

      while (!stack.isEmpty() && stack.lastElement().right != null) {
        stack.pop();
      }
    }
  }

  private String preOrderToString(Node node) {
    if (node == null) return "";
    var string = "";
    string += node.content;
    if (node.left != null) string += " " + preOrderToString(node.left);
    if (node.right != null) string += " " + preOrderToString(node.right);
    return string;
  }

  private String inOrderToString(Node node) {
    if (node == null) return "";
    var string = "";
    if (node.left != null) string += inOrderToString(node.left) + " ";
    string += node.content;
    if (node.right != null) string += " " + inOrderToString(node.right);
    return string;
  }
}
