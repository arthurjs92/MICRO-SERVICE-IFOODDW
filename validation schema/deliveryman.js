db.createCollection("deliverymans", {
  validator: {
    $jsonSchema: {
      required: ["name", "cpf", "plate", "store"],
      properties: {
        name: {
          bsonType: "string",
          maxLength: 64,
          description: "DeliveryMan Name.",
        },
        cpf: {
          bsonType: "string",
          maxLength: 11,
          description: "CPF.",
        },
        licensePlate: {
          bsonType: "string",
          maxLength: 7,
          description: "License plate.",
        },
        store: {
          bsonType: "object",
          description: "Store Id",
        },
      },
    },
  },
});
