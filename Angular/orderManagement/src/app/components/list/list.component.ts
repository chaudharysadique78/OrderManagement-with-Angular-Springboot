import { Component, OnInit } from '@angular/core';
import Order from 'src/app/Entity/Order';
import { OrderService } from 'src/app/service/order.service';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {

  order: Order = new Order();
  orders: Order[] = [];

  constructor(public orderService: OrderService) { }

  ngOnInit(): void {
    const promise = this.orderService.getOrder();
    promise.subscribe((response) => {
      console.log(response);
      this.orders = response as Order[];
    })
  }

  deleteRow(order, index) {
    const observable = this.orderService.deleteOrder(order);
    observable.subscribe((response: any) => {
      console.log(response);
      this.orders.splice(index, 1)
    })
  }

  }

