from flask import render_template
from app import app


@app.route('/')
@app.route('/index')
def index():
    return render_template('index.html')

@app.route('/graph')
def graph():
    return render_template('graph.html')

@app.route('/googleMap')
def googleMap():
    return render_template('googleMap.html')

@app.route('/heatmap')
def heatmap():
    return render_template('heatmap.html')

