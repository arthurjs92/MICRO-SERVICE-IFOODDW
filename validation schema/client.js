db.createCollection("clients", {
  validator: {
    $jsonSchema: {
      required: ["name", "cpf"],
      properties: {
        name: {
          bsonType: "string",
          maxLength: 64,
          description: "Client Name.",
        },
        cpf: {
          bsonType: "string",
          maxLength: 11,
          description: "CPF.",
        },
        address: {
          bsonType: "array",
          description: "Client Address",
        },
      },
    },
  },
});
