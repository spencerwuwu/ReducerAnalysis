// Note: only +, - operations
// Parameters:
//   Variables:   10
//   Baselines:   100
//   If-Branches: 2

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
int cur_ = 0;

while (iter.hasNext()) {
cur_ = iter.next().get();
a003_ = a008_ - a001_;
a002_ = cur_ - a009_;
cur_ = a006_ + a003_;
cur_ = a005_ + a000_;
a006_ = cur_ - a001_;
a005_ = a003_ + a004_;
a001_ = a001_ - a005_;
a008_ = a006_ + a009_;
a003_ = a006_ - a007_;
a004_ = a008_ - cur_;
a008_ = a006_ - a007_;
a001_ = a004_ + a008_;
a008_ = a009_ - a002_;
cur_ = a005_ - a002_;
a005_ = a003_ + a004_;
a006_ = a003_ - a003_;
a008_ = a003_ + a005_;
a003_ = a008_ - a008_;
a009_ = a007_ + a009_;
a006_ = a007_ + a007_;
a004_ = a004_ - a001_;
a008_ = a002_ - a007_;
a007_ = a009_ - a000_;
a003_ = a008_ + a009_;
if (a003_ >= a001_) {
a000_ = -3 + a004_;
a004_ = a008_ - 2;
a002_ = a003_ - a006_;
a000_ = a006_ - a000_;
a005_ = a004_ - a004_;
a004_ = a003_ + a004_;
a005_ = a001_ - a006_;
a004_ = a006_ - a006_;
a002_ = a002_ + a003_;
a003_ = a003_ - a005_;
a001_ = a009_ - -3;
a008_ = a007_ + a000_;
a007_ = a007_ - a007_;
a006_ = a008_ - a008_;
a007_ = a006_ + a004_;
a005_ = a002_ - a002_;
a004_ = -4 + cur_;
} else {
a006_ = cur_ + a008_;
a006_ = a004_ + cur_;
a002_ = a009_ - a003_;
if (a004_ != a009_) {
a000_ = a009_ + a009_;
a009_ = a003_ - a008_;
a004_ = a002_ + a005_;
a004_ = a008_ - a003_;
a006_ = a003_ - 0;
a003_ = a002_ + 3;
a000_ = a005_ + a005_;
a007_ = cur_ - a000_;
a004_ = a002_ + a008_;
a006_ = a001_ + a001_;
a006_ = a008_ + a005_;
a005_ = -2 + a006_;
a007_ = a005_ + cur_;
a008_ = a000_ - a002_;
a002_ = a003_ + a004_;
a002_ = 4 - a002_;
a009_ = a003_ + cur_;
a003_ = a009_ + a008_;
a001_ = a007_ + a009_;
a003_ = -1 + a009_;
a005_ = a008_ - -3;
a000_ = a003_ - a001_;
a001_ = a005_ + a001_;
} else {
a001_ = cur_ - a009_;
a004_ = a006_ - a009_;
a001_ = a003_ - a000_;
a004_ = a009_ - a008_;
a007_ = -1 - a000_;
a001_ = a004_ + a001_;
a009_ = a000_ + a009_;
a003_ = a008_ + a008_;
a006_ = a004_ - a008_;
a007_ = a004_ - a009_;
a009_ = -2 + a000_;
a007_ = a009_ + 4;
a003_ = a002_ - a009_;
a003_ = 0 + a005_;
a006_ = a007_ - a002_;
a006_ = cur_ - a006_;
a005_ = a007_ - a003_;
a001_ = a004_ + -4;
a005_ = a001_ - a001_;
a006_ = a004_ + a008_;
a001_ = a003_ + a000_;
a006_ = -5 + 0;
a007_ = a005_ + -1;
cur_ = a000_ + a000_;
a006_ = a009_ - a004_;
a001_ = cur_ * -1;
a002_ = a000_ - a000_;
}
a001_ = a008_ - a007_;
a006_ = a008_ + a005_;
a002_ = a007_ + 0;
}
a005_ = a005_ + a001_;
a009_ = a006_ - a009_;
a002_ = cur_ + a005_;
}
output.collect(prefix, new IntWritable(a009_));
}
