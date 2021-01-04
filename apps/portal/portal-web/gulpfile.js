const { readFileSync } = require('fs');
const gulp = require('gulp');
const babel = require("gulp-babel");
const watch = require('gulp-watch');
const browserSync = require('browser-sync').create();
const environments = require('gulp-environments');
const uglifycss = require('gulp-uglifycss');
const terser = require('gulp-terser');
const sass = require('gulp-sass');
const purgecss = require('gulp-purgecss');
const rev = require('gulp-rev');
const revRewrite = require('gulp-rev-rewrite');

sass.compiler = require('node-sass');

const production = environments.production;

gulp.task('watch', () => {
  browserSync.init({
    proxy: 'localhost:8080',
  });
  gulp.watch(['src/main/assets/scss/*.css'], gulp.series('copy-css-and-reload'));
  gulp.watch(['src/main/assets/js/*.js'], gulp.series('copy-js-and-reload'));
});

gulp.task('copy-css', () =>
  gulp.src(['src/main/assets/scss/app.scss'])
    .pipe(sass().on('error', sass.logError))
    .pipe(production(purgecss({
      content: ['src/main/resources/templates/**/*.html.peb']
    })))
    .pipe(production(uglifycss()))
    .pipe(rev())
    .pipe(gulp.dest('src/main/resources/static/css'))
    .pipe(rev.manifest())
    .pipe(gulp.dest('src/main/resources/static/css'))
);

gulp.task('copy-js', () =>
  gulp.src(['src/main/assets/js/app.js'])
    .pipe(babel())
    .pipe(production(terser()))
    .pipe(rev())
    .pipe(gulp.dest('src/main/resources/static/js'))
    .pipe(rev.manifest())
    .pipe(gulp.dest('src/main/resources/static/js'))
);

gulp.task('rev-rewrite', function() {
  const manifestCss = readFileSync('src/main/resources/static/css/rev-manifest.json');
  const manifestJs = readFileSync('src/main/resources/static/js/rev-manifest.json');

  return gulp.src('src/main/resources/templates/layouts/*.html.peb')
    .pipe(revRewrite({ manifest: manifestCss }))
    .pipe(revRewrite({ manifest: manifestJs }))
    .pipe(gulp.dest('src/main/resources/templates/layouts/'));
});

gulp.task('copy-css-and-reload', gulp.series('copy-css', reload));
gulp.task('copy-js-and-reload', gulp.series('copy-js', reload));
gulp.task('build', gulp.series('copy-css', 'copy-js', 'rev-rewrite'));
gulp.task('default', gulp.series('watch'));

function reload(done) {
  browserSync.reload();
  done();
}
