// Note: only +, - operations
// Parameters:
//   Variables:   25
//   Baselines:   250
//   If-Branches: 5

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
int a020_ = 0;
int a021_ = 0;
int a022_ = 0;
int a023_ = 0;
int a024_ = 0;
int cur_ = 0;

while (iter.hasNext()) {
cur_ = iter.next().get();
a005_ = a003_ - a016_;
a013_ = a019_ - a011_;
a014_ = a012_ - a011_;
a021_ = a011_ + a024_;
a010_ = a001_ - a023_;
a005_ = a007_ - a009_;
a021_ = a009_ + a006_;
a003_ = a012_ - a002_;
a001_ = a002_ + a017_;
a019_ = a012_ - cur_;
a009_ = a006_ - 4;
a007_ = a017_ + a005_;
a002_ = a015_ + a000_;
a019_ = a007_ + a017_;
a009_ = a000_ - a003_;
a010_ = a015_ - a012_;
a002_ = a016_ + a023_;
if (a003_ <= a019_) {
a010_ = 2 - a003_;
a014_ = a002_ + a010_;
a005_ = a019_ - -3;
a019_ = a000_ + a006_;
a012_ = a002_ - 0;
a006_ = a014_ - a013_;
a001_ = a003_ + a016_;
a019_ = a019_ - a013_;
a020_ = cur_ + a009_;
a021_ = a022_ - a023_;
a004_ = a014_ - a004_;
a023_ = a008_ - a011_;
a018_ = a003_ - a001_;
a016_ = a021_ - a016_;
a002_ = a015_ - a008_;
a017_ = cur_ + a005_;
a005_ = a014_ - a024_;
a020_ = a009_ + a022_;
a018_ = a018_ - a005_;
a015_ = a014_ - a014_;
a000_ = a002_ + a013_;
a000_ = a007_ - a021_;
a020_ = a005_ + a009_;
a001_ = a022_ - a007_;
if (a003_ != cur_) {
a024_ = a023_ - a000_;
a024_ = a022_ - cur_;
a001_ = a022_ + a004_;
a007_ = a008_ - a024_;
a016_ = a019_ - a000_;
a007_ = a022_ + a008_;
a022_ = a003_ + a020_;
a001_ = a008_ + cur_;
a011_ = a008_ - a020_;
a007_ = a002_ - a018_;
a011_ = a016_ - a012_;
a012_ = a018_ + a015_;
a023_ = a016_ - a005_;
a008_ = a020_ - a018_;
a011_ = a006_ + cur_;
a022_ = a022_ - a013_;
cur_ = -3 + a008_;
a000_ = a001_ + a019_;
a023_ = a019_ - a024_;
a019_ = a003_ - a010_;
a011_ = a021_ + a007_;
a000_ = a006_ + a007_;
a009_ = a012_ - a005_;
a021_ = a012_ + a013_;
cur_ = a010_ - a023_;
if (a007_ != a015_) {
a009_ = a017_ + a021_;
a010_ = a024_ - a022_;
a011_ = a023_ - a014_;
a006_ = a015_ + a004_;
a008_ = a008_ - a004_;
a019_ = a004_ - a016_;
a016_ = a002_ - a023_;
a023_ = a001_ + a014_;
a023_ = a021_ + a024_;
a008_ = a003_ - a003_;
a023_ = a006_ + a007_;
a001_ = a012_ + a011_;
a014_ = a021_ - a008_;
a020_ = a000_ - a023_;
a002_ = a018_ + a003_;
a013_ = a005_ + a004_;
a024_ = a013_ - a015_;
a007_ = a014_ - -1;
a005_ = a001_ - a003_;
a016_ = a020_ + a020_;
a023_ = a009_ - a004_;
a010_ = a010_ - a004_;
a022_ = a018_ + a008_;
a006_ = a010_ + a005_;
a001_ = a005_ - a008_;
a003_ = a019_ + a018_;
a000_ = a008_ + a009_;
a022_ = a009_ - a012_;
a000_ = -1 - a002_;
if (a004_ >= a021_) {
a004_ = a013_ - a021_;
a003_ = a007_ + a003_;
a022_ = a020_ - a008_;
a004_ = a022_ - a000_;
a004_ = a018_ - a001_;
a019_ = a003_ - a013_;
a014_ = a001_ + a012_;
a019_ = a014_ + a007_;
a021_ = cur_ - a018_;
a022_ = a002_ - a013_;
a001_ = a002_ + a013_;
a024_ = a003_ - a013_;
a009_ = a020_ - a008_;
a012_ = a024_ + -4;
a024_ = a015_ + a003_;
a014_ = a009_ - a008_;
a011_ = a003_ + a017_;
a022_ = a005_ + cur_;
a009_ = a011_ + a019_;
a021_ = a009_ - a010_;
a022_ = a018_ - a014_;
a022_ = a012_ + a022_;
a011_ = a023_ - a000_;
a005_ = a021_ + a019_;
a009_ = a000_ + a012_;
a000_ = a001_ - a011_;
a000_ = a014_ - a011_;
a017_ = a011_ + -5;
a014_ = a013_ + a002_;
a000_ = a014_ + a008_;
} else {
a008_ = a009_ + a000_;
a000_ = a008_ - a011_;
a001_ = a017_ + a002_;
a014_ = a001_ - a008_;
a003_ = a023_ - a020_;
a000_ = a015_ - a014_;
a017_ = a013_ - a023_;
a005_ = a003_ + a012_;
a004_ = a022_ + a013_;
a002_ = a021_ + a013_;
a013_ = a024_ - a016_;
a020_ = a002_ - a013_;
a001_ = 1 - a023_;
a007_ = a009_ + a018_;
a010_ = a012_ + a008_;
a003_ = a009_ - a000_;
a010_ = a020_ - a006_;
a022_ = a014_ + a003_;
a000_ = a007_ - a014_;
a013_ = a009_ - a001_;
a012_ = a009_ + a015_;
a010_ = a007_ - a022_;
if (a010_ < a013_) {
a012_ = a008_ - a002_;
a024_ = a017_ - a024_;
a002_ = a003_ + a005_;
a000_ = a019_ - a000_;
a011_ = a005_ + -2;
a003_ = a004_ + a024_;
a008_ = a017_ + a024_;
a013_ = a021_ + a015_;
a003_ = -3 + a008_;
a008_ = a016_ + a000_;
a012_ = a002_ - a000_;
cur_ = a000_ + -2;
a015_ = a003_ + a008_;
a008_ = a013_ + a006_;
a024_ = a007_ + a010_;
a002_ = a000_ + a005_;
a016_ = a022_ - a011_;
a011_ = a007_ + a024_;
a005_ = a024_ - a005_;
a014_ = a002_ - cur_;
a012_ = a006_ + a024_;
a009_ = a000_ + a017_;
a006_ = a007_ + a014_;
a011_ = a021_ + a009_;
a021_ = a011_ + a018_;
a015_ = a021_ + a012_;
a000_ = a016_ - a001_;
a001_ = a024_ - a005_;
} else {
a024_ = a014_ + a016_;
}
a002_ = a013_ + a020_;
a017_ = a013_ - a022_;
a003_ = a024_ - a013_;
a006_ = a015_ + a014_;
a006_ = a005_ + a022_;
a001_ = 3 - a021_;
a000_ = a013_ - a015_;
a017_ = a006_ + a019_;
a002_ = a021_ - a010_;
a020_ = cur_ + a021_;
}
a002_ = a010_ - a019_;
a009_ = 4 + a007_;
a011_ = a002_ - a006_;
a021_ = a009_ - a008_;
a019_ = a021_ + a006_;
a007_ = a008_ + a023_;
a023_ = a002_ + a012_;
a015_ = a002_ + a017_;
a007_ = a016_ + a008_;
a003_ = a018_ - a017_;
a022_ = a005_ - a023_;
a017_ = a005_ - a012_;
a001_ = a024_ - -5;
} else {
a021_ = a013_ + -3;
a007_ = a001_ - a018_;
a016_ = a014_ - a008_;
a004_ = a024_ + a007_;
a016_ = a018_ - a010_;
a011_ = a003_ - a015_;
a023_ = a022_ - a011_;
a024_ = a021_ + a016_;
a016_ = a003_ + a006_;
a001_ = a004_ + a018_;
a022_ = a020_ - a002_;
a006_ = -1 - a003_;
a003_ = a002_ - a023_;
a012_ = a012_ - a023_;
a023_ = a008_ + a010_;
a014_ = a010_ + a019_;
}
a002_ = a018_ - a001_;
a009_ = a001_ - a015_;
a012_ = a020_ + a011_;
a018_ = a023_ - a012_;
a023_ = a002_ + a009_;
a018_ = a021_ + a008_;
a005_ = a003_ - a000_;
a008_ = a024_ + a022_;
a013_ = a004_ + 2;
a016_ = a003_ - a022_;
cur_ = a010_ - a013_;
a018_ = a010_ - a016_;
a011_ = a007_ - a002_;
a020_ = a003_ - a012_;
a010_ = a004_ - a007_;
a012_ = a024_ + a014_;
a014_ = a001_ - a015_;
a017_ = a021_ + a016_;
a017_ = cur_ + a022_;
a011_ = a006_ + a018_;
cur_ = a003_ + -2;
a020_ = a009_ - a013_;
a019_ = a010_ - a018_;
a018_ = a013_ - a005_;
a006_ = a003_ + a012_;
a002_ = a002_ - a014_;
a010_ = a005_ - a023_;
a021_ = a001_ - a011_;
a008_ = a008_ + a021_;
a004_ = a009_ + a001_;
a020_ = a002_ - a018_;
a011_ = a018_ + a005_;
} else {
}
a022_ = a005_ + 3;
a001_ = a021_ - a000_;
} else {
}
a018_ = a017_ - -4;
}
output.collect(prefix, new IntWritable(a000_));
}
