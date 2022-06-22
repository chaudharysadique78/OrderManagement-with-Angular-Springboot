import { Component, OnInit } from '@angular/core';
import Order from 'src/app/Entity/Order';
import { OrderService } from 'src/app/service/order.service';

@Component({
  selector: 'app-orderform',
  templateUrl: './orderform.component.html',
  styleUrls: ['./orderform.component.css']
})
export class OrderformComponent implements OnInit {
  order: Order = new Order();
  orders: Order[] = [];

  save() {
    // console.log(this.order.orderName");
    // console.log(this.order.orderPriceuser);
    const observable = this.orderService.createUser(this.order);
    observable.subscribe(
      (response: any) => {
        console.log(response);
      },
      function (error) {
        console.log(error);
        alert("Something went wrong")
      }
    )
  }

  constructor(public orderService: OrderService) { }

  ngOnInit(): void {
  }

}
