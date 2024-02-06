echo "-> Run bash individually - Type 'employee-servicebuild' to build the project"
employee-servicebuild() {
  echo "mvn clean package"
  mvn clean package
}
echo "-> Run bash individually - Type 'employee-servicek8s' to run the executable"
employee-servicek8s() {
  echo "Running executable > mvn k8s:resource k8s:build"
  mvn k8s:resource k8s:build
}
echo "-> Run bash individually - Type 'employee-serviceregistryk8s' to run the executable"
employee-servicek8sregistry() {
  echo "Running executable > mvn k8s:resource k8s:build k8s:push -Pregistry-k8s"
  mvn k8s:resource k8s:build k8s:push -Pregistry-k8s
}
echo "-> Run bash individually - Type 'employee-servicerun' to run the executable"
employee-servicerun() {
  echo "Running executable > mvn spring-boot:run"
  mvn spring-boot:run
}
