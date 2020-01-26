node {
// Select SCM: source code management
        stage("Pulling code from github") {
           git 'https://github.com/Bobojon4450/web-orders.git'
        }

// build
        stage("Running tests") {
            if (isUnix()) {
                sh label: '', script: 'mvn clean test'
            }else{
                bat label: '', script: 'mvn clean test'
            }
        }

// generate report
        stage("Generate cucumber report"){
            cucumber fileIncludePattern: '**/*.json', sortingMethod: 'ALPHABETICAL'
        }

//send email
        stage("Send email"){
            emailext body:
            '''${JELLY_SCRIPT, template="html"}
            $PROJECT_NAME - Build # $BUILD_NUMBER - $BUILD_STATUS
            <br>
            <strong>Check Cucumber HTML report: $PROJECT_URL/$BUILD_NUMBER/cucumber-html-reports/overview-features.html</strong>''',
            subject: 'Smoke test status: $BUILD_STATUS',
            to: 'bobojon.rva@gmail.com'
        }

        stage("Send slack notification"){
            slackSend channel: 'jenkins', message: "Smoke test status: passed", username: 'jenkins'
        }
}