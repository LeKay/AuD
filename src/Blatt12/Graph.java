package Blatt12;

public class Graph
{
	private static double[][] matrix1 =
	{
		{0.0, 5.0, 0.0, 0.0, 0.0, 0.0},
		{5.0, 0.0, 5.0, 5.0, 0.0, 0.0},
		{0.0, 5.0, 0.0, 5.0, 0.0, 0.0},
		{0.0, 5.0, 5.0, 0.0, 0.0, 0.0},
		{0.0, 0.0, 0.0, 0.0, 5.0, 0.0},
		{0.0, 0.0, 0.0, 0.0, 0.0, 5.0},
	};

	private static double[][] matrix2 =
	{
		{0.0, 5.0, 0.0, 0.0, 0.0, 0.0},
		{0.0, 0.0, 5.0, 5.0, 0.0, 0.0},
		{0.0, 5.0, 0.0, 5.0, 0.0, 0.0},
		{0.0, 5.0, 5.0, 0.0, 0.0, 0.0},
		{0.0, 0.0, 0.0, 0.0, 5.0, 0.0},
		{0.0, 0.0, 0.0, 0.0, 0.0, 5.0},
	};

	private static boolean isSymmetric(final double[][] matrix)
	{
		assert(matrix!=null);
		assert(matrix[0]!=null);
		assert(matrix.length==matrix[0].length);

		// TODO
		return false;
	}

	private static boolean isTriviallyWeighted(final double[][] matrix)
	{
		assert(matrix!=null);
		assert(matrix[0]!=null);
		assert(matrix.length==matrix[0].length);

		// TODO
		return false;
	}

	public static void main(String[] args)
	{
		System.out.println("isSymmetric: " + isSymmetric(matrix1) + ", " + isSymmetric(matrix2));
		System.out.println("isTriviallyWeighted: " + isTriviallyWeighted(matrix1) + ", " + isTriviallyWeighted(matrix2));
	}
}