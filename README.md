DESCRIÇÃO DA SAÍDA DA COMPILAÇÃO
========================

Ao compilar um projeto de aplicação Java que possui uma classe principal, a IDE
copia automaticamente todos os arquivos JAR
presentes no *classpath* do projeto para a pasta `dist/lib` do projeto. A IDE
também adiciona cada um dos arquivos JAR ao elemento `Class-Path` no arquivo
de manifesto (MANIFEST.MF) do arquivo JAR da aplicação.

Para executar o projeto a partir da linha de comando, vá até a pasta `dist` e
digite o seguinte:

java -jar "sistema.jar"

Para distribuir este projeto, compacte a pasta `dist` (incluindo a pasta `lib`)
em um arquivo ZIP e distribua esse arquivo.

Observações:

* Se dois arquivos JAR no *classpath* do projeto tiverem o mesmo nome, apenas o primeiro
arquivo JAR será copiado para a pasta `lib`.
* Apenas arquivos JAR são copiados para a pasta `lib`.
Se o *classpath* contiver outros tipos de arquivos ou pastas, esses arquivos (ou pastas)
não serão copiados.
* Se uma biblioteca no *classpath* do projeto também possuir um elemento `Class-Path`
especificado no manifesto, o conteúdo desse elemento `Class-Path` deverá estar
presente no caminho de execução (*runtime path*) do projeto.
* Para definir uma classe principal em um projeto Java padrão, clique com o botão direito no nó
do projeto na janela Projetos (*Projects*) e escolha Propriedades (*Properties*). Em seguida,
clique em Executar (*Run*) e insira o nome da classe no campo Classe Principal (*Main Class*).
Alternativamente, você pode digitar manualmente o nome da classe no elemento
`Main-Class` do manifesto.
