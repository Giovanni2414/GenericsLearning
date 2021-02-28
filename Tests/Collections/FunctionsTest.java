package Collections;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import Model.Objects;

class FunctionsTest {

	LinkedList<Objects> list;
	
	/**
	 * Setup stage1
	 * @return A LinkedList without data
	 */
	private LinkedList<Objects> setupStage1()
	{
		return list = new LinkedList<>();
	}
	
	/**
	 * Setup stage2
	 * @return A linkedList with data
	 */
	private LinkedList<Objects> setupStage2()
	{
		list = new LinkedList<>();
		list.addToList(new Objects("Giovanni", 1000));
		list.addToList(new Objects("Estela", 1001));
		list.addToList(new Objects("Gabriela", 1002));
		list.addToList(new Objects("Edna", 1003));
		return list;
	}
	
	@Test
	public void addToListTest()
	{
		LinkedList<Objects> list = setupStage1();
		list.addToList(new Objects("Giovanni", 1000));
		list.addToList(new Objects("Estela", 1001));
		list.addToList(new Objects("Gabriela", 1002));
		list.addToList(new Objects("Edna", 1003));
		list.getRoot();
		assertEquals(list.getRoot().getElement().getNit(), 1000, "Root don't added");
		assertEquals(list.getRoot().getNext().getElement().getNit(), 1001, "Added in bad order");
		assertEquals(list.getRoot().getNext().getNext().getElement().getNit(), 1002, "Added in bad order");
		assertEquals(list.getRoot().getNext().getNext().getNext().getElement().getNit(), 1003, "Added in bad order");
		assertNotEquals(list.getRoot().getElement().getNit(), 1001, "Root order incorrect");
		assertNotEquals(list.getRoot().getElement().getNit(), 1002, "Root order incorrect");
	}
	
	@Test
	public void getLengthTest()
	{
		LinkedList<Objects> list = setupStage2();
		assertEquals(4, list.getLength());
		assertEquals("Gabriela", list.deletePosition(2).getName());
		assertEquals(3, list.getLength());
	}
	
	@Test
	public void clearListTest()
	{
		LinkedList<Objects> list = setupStage2();
		assertTrue(list.clearList());
		assertFalse(list.clearList());
	}
	
	@Test
	public void getElementByPosition()
	{
		LinkedList<Objects> list = setupStage2();
		assertEquals("Edna", list.getElementByPosition(3).getName());
		assertNull(list.getElementByPosition(5));
		assertNotNull(list.getElementByPosition(0));
	}
	
	@Test
	public void deletePositionTest()
	{
		LinkedList<Objects> list = setupStage2();
		assertEquals("Giovanni", list.deletePosition(0).getName());
		assertEquals(3, list.getLength());
		assertEquals("Edna", list.deletePosition(2).getName());
		assertEquals(2, list.getLength());
	}
	
	@Test
	public void getElementPositionTest()
	{
		LinkedList<Objects> list = setupStage2();
		Objects objectToFind = new Objects("Melussi", 1004);
		list.addToList(objectToFind);
		assertEquals(4, list.getElementPosition(objectToFind));
	}
	
	@Test
	public void deleteElementTest()
	{
		LinkedList<Objects> list = setupStage2();
		Objects objectToDelete = new Objects("Melussi", 1004);
		list.addToList(objectToDelete);
		assertTrue(list.deleteElement(objectToDelete));
	}
	
	@Test
	public void isEmptyTest()
	{
		LinkedList<Objects> list = setupStage1();
		assertTrue(list.isEmpty());
		list.addToList(new Objects("Melussi", 1004));
		assertFalse(list.isEmpty());
	}
	
}
