# Rick and Morty DEMO
Это демо тестирования API Rick and Morty.
Главная страница API Rick and Morty: [API](https://rickandmortyapi.com/)
Документаци по API: [Документация](https://rickandmortyapi.com/documentation)

### Теста написанны с использованием следующих технологий:
 - Java
 - Cucumber
 - TestNG
 - Rest Assured
 - Hamcrest
 - Lombok
 - Allure

### Запуск тестов

- ##### Maven

Данную команду нужно выполнить в папке проекта.
```
mvn clean test site
```
- ##### Docker 

Чтобы запустить Docker контейнер нужно выполнить следующую команду:
```
docker run -it -v [path_to_folder_on_host]:/Rick_and_Morty_Demo/target/allure-report/ bogdan2641/test_rick_and_morty_demo mvn test site
```
[path_to_folder_on_host] - путь, где будет сохранен отчет из контейнера на хост машине.
/Rick_and_Morty_API_DEMO_example/target/allure-report/ - путь, где храниться Allure-report в контейнере.
testbuild - имя Docker образа, на основе которого будет создаваться и запускаться Docker контейнер с тестами.
mvn test site - команды maven которые будут выполнены внутри контейнера.

К примеру
```
docker run -it -v D:\Docker_report\allure\:/Rick_and_Morty_Demo/target/allure-report/ bogdan2641/test_rick_and_morty_demo mvn test site
```

- ##### Jenkins
Данный код описан в jenkinsfile. Данный код описывает Pipeline Jenkins, он скачивает проект с GitHub, запускает его и по итогу выполнения теста отправляет в Slack канал Allure-report с комментарием, кто последний вносил изменение в GitHub репозиторий проекта.
```
def coder
def COLOR_MAP = ['SUCCESS': 'good', 'FAILURE': 'danger', 'UNSTABLE': 'warning', 'ABORTED': 'danger']

node{
    stage('Clone repository.'){
        git 'https://github.com/PressF5/Rick_and_Morty_Demo.git'
    }
    stage('Run tests.'){
        try{
            bat 'mvn clean test'
        } catch(e) {
            currentBuild.result = "FAILURE"
            echo e.toString()  
        }
        coder = powershell(returnStdout: true, script: 'git log -1 --pretty=format:\'[%an %ae]\'').trim()
    }
    stage('Report generation.'){
        allure includeProperties: false, jdk: '', results: [[path: 'target/allure-results']]
    }
    stage('Send report in Slack channel.') {
        
        slackSend botUser: true, 
        channel: 'jenkins',
        color: COLOR_MAP[currentBuild.currentResult],
        message: "Name of Job: ${JOB_NAME} | Number of build: ${BUILD_NUMBER} | Result of build: ${currentBuild.currentResult} | Last change: ${coder}",
        teamDomain: 'Test_slack_jenkins', 
        tokenCredentialId: 'a5351553-fcd2-478d-a122-8e5ff8c99925'
        
        dir("${JENKINS_HOME}/jobs/Rick_and_Morty/builds/${BUILD_NUMBER}/archive") {
            slackUploadFile channel: 'jenkins', 
            credentialId: 'a5351553-fcd2-478d-a122-8e5ff8c99925', 
            filePath: 'allure-report.zip', 
            initialComment: 'Allure Report.'
        }
    }
}
```
Rick_and_Morty - название Jenkins job.
Для отправки Allure-report в Slack канал, нужно создать и настроить своего Slack-bot и Slack канал. Документация по созданию [Slack-bot](https://api.slack.com/bot-users).

### Просмотр отчета Allure
Чтобы просмотреть отчет от allure нужно установить [allure-commandline](https://www.npmjs.com/package/allure-commandline) и выполнить следующую команду:
```
allure open [path_to_folder_with_report]
```
path_to_folder_with_report - путь к папке с отчетом
К примеру:
```
allure open /target/allure-report/
allure open D:/allure_report/
```
