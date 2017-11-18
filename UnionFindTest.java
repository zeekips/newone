package edu.upenn.cis121.hw9;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UnionFindTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test(expected = java.lang.IllegalArgumentException.class)
	public void testConstructorException() 
	throws Exception{
		UnionFind newUF = new UnionFind(-4);
	}
	
	@Test
	public void testUnionStandard()
	throws Exception{
		UnionFind newUF = new UnionFind(5);
		newUF.union(0, 1);
		newUF.union(0, 2);
		newUF.union(3, 4);
		assertTrue(newUF.connected(1, 2));
	}
	
	@Test
	public void testFindStandard()
	throws Exception{
		UnionFind newUF = new UnionFind(5);
		newUF.union(0, 1);
		newUF.union(0, 2);
		assertEquals(newUF.find(1), newUF.find(2));
	}
	
	@Test(expected = java.util.NoSuchElementException.class)
	public void testFindNegativeException()
	throws Exception{
		UnionFind newUF = new UnionFind(5);
		newUF.find(-4);
	}
	
	@Test(expected = java.util.NoSuchElementException.class)
	public void testFindLargeException()
	throws Exception{
		UnionFind newUF = new UnionFind(5);
		newUF.find(10);
	}
	
	@Test(expected = java.util.NoSuchElementException.class)
	public void testUnionNegativeException()
	throws Exception{
		UnionFind newUF = new UnionFind(5);
		newUF.union(-4, -2);
	}
	
	@Test(expected = java.util.NoSuchElementException.class)
	public void testUnionLargeException()
	throws Exception{
		UnionFind newUF = new UnionFind(5);
		newUF.union(10, 20);
	}
	
	@Test
	public void testUnionConnected() {
		UnionFind newUF = new UnionFind(5);
		newUF.union(0, 1);
		newUF.union(0, 1);
	}
	
	@Test 
	public void testManyUnions() {
		UnionFind newUF = new UnionFind(7);
		newUF.union(0, 1);
		newUF.union(1, 2);
		newUF.union(1, 3);
		newUF.union(2, 4);
		newUF.union(0, 5);
		assertTrue(newUF.connected(1, 5));
	}
	

}
