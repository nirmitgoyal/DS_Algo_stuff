package models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
public class ListNode {

  public int data;
  public ListNode next = null;

  public ListNode(int data) {
    this.data = data;
    this.next = null;
  }
}
