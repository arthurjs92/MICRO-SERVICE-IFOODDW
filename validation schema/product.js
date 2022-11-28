db.createCollection("products", {
  validator: {
    $jsonSchema: {
      required: ["name", "price"],
      properties: {
        name: {
          bsonType: "string",
          maxLength: 64,
          description: "Name of Product.",
        },
        price: {
          bsonType: "double",
          minimum: 1,
          maximum: 10000,
          description: "Price of Product",
        },
      },
    },
  },
});
