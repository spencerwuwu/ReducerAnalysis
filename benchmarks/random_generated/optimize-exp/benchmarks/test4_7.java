// Note: only +, - operations
// Parameters:
//   Variables:   20
//   Baselines:   200
//   If-Branches: 4

public void reduce(Text prefix, Iterator<IntWritable> iter,
         OutputCollector<Text, IntWritable> output, Reporter reporter) throws IOException {
int a000_ = 0;
int a001_ = 0;
int a002_ = 0;
int a003_ = 0;
int a004_ = 0;
int a005_ = 0;
int a006_ = 0;
int a007_ = 0;
int a008_ = 0;
int a009_ = 0;
int a010_ = 0;
int a011_ = 0;
int a012_ = 0;
int a013_ = 0;
int a014_ = 0;
int a015_ = 0;
int a016_ = 0;
int a017_ = 0;
int a018_ = 0;
int a019_ = 0;
int cur_ = 0;

while (iter.hasNext()) {
cur_ = iter.next().get();
a019_ = cur_ - a010_;
a017_ = a014_ - a005_;
a000_ = a005_ + a002_;
a013_ = a003_ + a006_;
a002_ = a018_ + a016_;
a016_ = a014_ + a006_;
a016_ = a017_ - a008_;
a013_ = a015_ - a001_;
a002_ = a005_ + cur_;
a000_ = a009_ + a016_;
a017_ = a010_ - cur_;
a009_ = a006_ + a016_;
a018_ = a004_ + a019_;
a009_ = a007_ + a003_;
a015_ = a007_ + a011_;
a012_ = a004_ - a017_;
a001_ = a013_ - a006_;
a006_ = a018_ + a006_;
a009_ = a002_ + a005_;
a011_ = a010_ - cur_;
if (a010_ >= a004_) {
cur_ = a004_ - a007_;
a000_ = a010_ + a002_;
a008_ = a014_ + a001_;
a015_ = a012_ + a009_;
a011_ = a000_ + a007_;
a014_ = 4 - a007_;
a000_ = a011_ + a006_;
a010_ = a019_ + a019_;
a018_ = a018_ - a019_;
a002_ = a008_ - a014_;
a012_ = a018_ - a006_;
a009_ = a006_ + a004_;
a014_ = a012_ - a003_;
a005_ = a017_ + a016_;
a010_ = -3 + a007_;
a019_ = a001_ - a012_;
a004_ = a001_ - a006_;
a018_ = a003_ + a009_;
a008_ = a018_ + cur_;
a008_ = a017_ + a007_;
a008_ = a010_ - a007_;
a008_ = a009_ - a004_;
a015_ = a008_ + a016_;
a007_ = a001_ - a011_;
a010_ = a019_ + a001_;
a003_ = a016_ + a011_;
a004_ = a016_ + a013_;
a012_ = a015_ + a002_;
a006_ = a018_ + a016_;
a017_ = a005_ - a005_;
a016_ = a014_ + a009_;
a005_ = a003_ - a007_;
a012_ = a015_ + a014_;
} else {
a004_ = a013_ - a016_;
a013_ = a001_ + a001_;
a016_ = a018_ - a013_;
a015_ = a019_ - a019_;
a012_ = a012_ - a010_;
a017_ = a004_ - cur_;
cur_ = a006_ + a014_;
a002_ = a015_ - a015_;
a006_ = a002_ - a005_;
a017_ = a014_ + a008_;
a014_ = a016_ - a012_;
a005_ = a011_ - a013_;
a009_ = a012_ - a017_;
}
a018_ = a003_ + a017_;
a017_ = a000_ - 3;
a019_ = a003_ + a017_;
a001_ = cur_ + a016_;
a013_ = -5 - 1;
a006_ = a017_ - a012_;
a005_ = a011_ - a015_;
a006_ = 3 - a001_;
a017_ = -4 + a007_;
a015_ = a002_ - a006_;
a008_ = a003_ + a008_;
a019_ = a001_ - a017_;
a012_ = a010_ + a015_;
a017_ = a016_ + a003_;
a006_ = a005_ - a001_;
a000_ = a000_ + a002_;
a011_ = a006_ + a018_;
cur_ = a005_ + a017_;
a001_ = a002_ + a011_;
a009_ = a004_ + a010_;
a008_ = a015_ + a015_;
a011_ = -2 - a015_;
a006_ = a006_ + a008_;
a011_ = a000_ + a018_;
a004_ = a004_ + a009_;
a019_ = a013_ + a006_;
a002_ = a004_ - a017_;
if (a004_ == a008_) {
cur_ = a012_ + a008_;
a016_ = a006_ + a019_;
a019_ = a003_ - a003_;
a016_ = a016_ + a003_;
a011_ = a002_ - a006_;
a012_ = a007_ - a006_;
a018_ = a008_ + a005_;
a013_ = a000_ - a004_;
a009_ = a007_ - a002_;
a001_ = a000_ - a009_;
a015_ = a018_ + a013_;
} else {
a007_ = a018_ - a017_;
a000_ = a002_ + a012_;
a002_ = a015_ + a010_;
a011_ = a017_ + a017_;
if (a004_ >= a008_) {
a012_ = a002_ - a015_;
a015_ = a003_ + a009_;
} else {
a016_ = -2 + a013_;
a003_ = a011_ + a019_;
a007_ = a007_ + a008_;
a011_ = a007_ + a008_;
a004_ = a015_ - a004_;
a009_ = a009_ + a018_;
a008_ = a003_ - a008_;
a010_ = a016_ + a012_;
a008_ = a001_ + 3;
a015_ = cur_ * -1;
a002_ = a004_ - a016_;
a014_ = a007_ - a017_;
a016_ = a019_ + a011_;
a013_ = a009_ + a001_;
if (a007_ == a013_) {
a009_ = a004_ + a005_;
a002_ = a012_ - a017_;
a003_ = a009_ - a002_;
a009_ = a013_ + a000_;
a015_ = a011_ + a015_;
a004_ = a000_ + -5;
a019_ = a010_ + a004_;
a016_ = a014_ - a018_;
a010_ = a008_ - a009_;
a019_ = a007_ - a018_;
a014_ = a017_ + a010_;
a005_ = a004_ - a009_;
a009_ = a003_ + cur_;
a019_ = a001_ - cur_;
a014_ = a002_ - a008_;
a002_ = a018_ + a004_;
a017_ = a007_ + a017_;
a005_ = a007_ - a014_;
a009_ = a000_ + a018_;
a017_ = a000_ - a009_;
a006_ = cur_ - a017_;
a007_ = a019_ + a005_;
a006_ = a015_ - a003_;
a018_ = a006_ + a005_;
a012_ = a003_ - 2;
a013_ = a000_ - a017_;
a013_ = a003_ + a010_;
a001_ = a015_ - a017_;
} else {
cur_ = a009_ + a014_;
a001_ = a004_ - a009_;
a018_ = a008_ - a000_;
a006_ = a005_ - a006_;
a001_ = a003_ - a013_;
a019_ = a013_ - a016_;
}
a003_ = a014_ + a016_;
a017_ = 2 + a008_;
a016_ = a009_ - a016_;
a008_ = a009_ - a002_;
a011_ = a001_ + a006_;
a002_ = a001_ - a016_;
a017_ = a013_ + a000_;
a001_ = a014_ + a016_;
a012_ = a017_ + a005_;
a019_ = a000_ - a006_;
a012_ = 2 - a007_;
cur_ = a010_ + a013_;
a008_ = a002_ + a018_;
a003_ = a019_ - a018_;
a015_ = a015_ + a016_;
a005_ = a005_ - a018_;
a005_ = a012_ - a002_;
a011_ = a016_ - a010_;
a006_ = a002_ + a005_;
a005_ = a014_ + a001_;
a016_ = a005_ + a004_;
a005_ = -4 + a010_;
a003_ = -1 - a009_;
a004_ = a007_ - a009_;
a000_ = a011_ + a008_;
a008_ = a018_ + a018_;
}
a009_ = a014_ - a014_;
a011_ = a004_ - a017_;
a005_ = cur_ - a016_;
a019_ = a012_ - a002_;
a002_ = a011_ + a006_;
cur_ = 4 + a016_;
}
a016_ = a001_ + cur_;
cur_ = a008_ - a000_;
a014_ = a005_ - a001_;
a009_ = 0 + a011_;
a006_ = cur_ + a011_;
a017_ = a000_ + a014_;
a014_ = a017_ + a003_;
a012_ = a000_ - a001_;
a003_ = a002_ + a003_;
a013_ = a009_ + a004_;
}
output.collect(prefix, new IntWritable(a009_));
}