db.createCollection("stores", {
  validator: {
    $jsonSchema: {
      required: ["name", "cnpj"],
      properties: {
        name: {
          bsonType: "string",
          maxLength: 64,
          description: "Client Name.",
        },
        cnpj: {
          bsonType: "string",
          minLength: 14,
          maxLength: 18,
          description: "Store CNPJ.",
        },
      },
    },
  },
});
