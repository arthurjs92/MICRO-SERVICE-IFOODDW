db.createCollection("orders", {
  validator: {
    $jsonSchema: {
      required: ["date", "totalPrice", "status", "user", "products"],
      properties: {
        date: {
          bsonType: "date",
          maxLength: 10,
          description: "Date of Order.",
        },
        totalPrice: {
          bsonType: "double",
          maxLength: 5,
          description: "Total Price of Order.",
        },
        status: {
          bsonType: "string",
          maxLength: 50,
          description: "Name of director.",
        },
        user: {
          bsonType: "object",
          description: "User that is making the order.",
        },
        products: {
          bsonType: "object",
          description: "Products of the Order",
        },
      },
    },
  },
});
