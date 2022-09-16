﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Frontend.Logic.Entities.Orders
{
    public class Orders
    {
        public ShippingAddress ShippingAddress { get; set; } = new();
        public OrderItems[]? OrderItems { get; set; }
    }
}