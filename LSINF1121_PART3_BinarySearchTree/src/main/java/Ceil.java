public class Ceil {
	/**
	 * Find in the tree the smallest element greater than or equal to value
	 * (so either the element itself or the element located directly after it
	 * in order of magnitude). If such an element does not exist,
	 * it must return null.
	 *
	 * Inserez votre reponse ici
	 */
	public static Integer ceil(Node root, int value) {
		//TODO by student
		Integer output = null;
		while (root != null){
			if (value == root.getValue()){
				return root.getValue();
			}
			else if (value < root.getValue()) {
				output = root.getValue();
				root = root.getLeft();
			}
			else {
				root = root.getRight();
			}
		}
		return output;
	}
}
