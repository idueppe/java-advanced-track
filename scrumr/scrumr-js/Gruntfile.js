/**
 * Created by idueppe on 24.09.14.
 */
module.exports = function(grunt) {
    grunt.initConfig ({
        uglify: {
            dist: {
                src: "src/fibonacci.js",
                dest: "dist/fibonacci.min.js"
            }
        },
        jshint: {
            files: ['src/*.js'],
            options: {
                curly: true,
                eqeqeq: true,
                immed: true,
                latedef: true,
                newcap: true,
                noarg: true,
                sub: true,
                undef: true,
                boss: true,
                eqnull: true,
                globals: { require: false, __dirname: false, console: false, module: false, exports: false }
            }
        }
    });
    grunt.loadNpmTasks('grunt-contrib-uglify');
    grunt.loadNpmTasks('grunt-contrib-jshint');
    grunt.registerTask('default', ['jshint','uglify']);
}