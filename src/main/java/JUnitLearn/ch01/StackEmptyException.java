package JUnitLearn.ch01;

/**
 * Excerpted from the book, "Pragmatic Unit Testing in Java with JUnit"
 * ISBN 0-9745140-1-2
 * Copyright 2003 The Pragmatic Programmers, LLC.  All Rights Reserved.
 * Visit www.PragmaticProgrammer.com
 */

public class StackEmptyException extends Exception {
  public StackEmptyException(String aString) {
    super(aString);
  }
}
