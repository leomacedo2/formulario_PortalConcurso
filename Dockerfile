FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY . .

RUN javac FormularioServidor.java

EXPOSE 8000

CMD ["java", "FormularioServidor"]
