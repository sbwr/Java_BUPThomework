import numpy as np
from PyQt5 import QtCore
from PyQt5.QtWidgets import QApplication, QLineEdit, QWidget, QFormLayout, QPushButton, QMessageBox, QLabel, \
    QVBoxLayout, QSizePolicy
import sys
import random
import matplotlib.pyplot as plt
from numpy.linalg import cholesky

Alist = []
Blist = []
Clist = []
Astr = []
Bstr = []
q = []


class initUI(QWidget):
    def __init__(self):
        super(initUI, self).__init__()
        self.setWindowTitle("数字波形生成器")
        self.resize(700, 700)
        flo = QFormLayout()
        self.Asequence = QLineEdit()
        self.Bsequence = QLineEdit()
        self.Fexpression = QLineEdit()
        self.Csequence = QLineEdit()
        self.bupt = QLabel("NULL")
        self.btn = QPushButton('运算')
        self.btn_1 = QPushButton("画图")
        self.Asequence.setInputMask("BBBBBBBB")
        self.Bsequence.setInputMask("BBBBBBBB")
        flo.addRow("A序列", self.Asequence)
        flo.addRow("B序列", self.Bsequence)
        flo.addRow("F表达式", self.Fexpression)
        flo.addRow("运算结果", self.Csequence)
        flo.addWidget(self.btn)
        flo.addWidget(self.btn_1)
        flo.addWidget(self.bupt)
        self.setLayout(flo)
        self.btn.clicked.connect(self.on_click)
        self.btn_1.clicked.connect(self.paintA)

    def on_click(self):
        Astr = self.Asequence.text()
        Bstr = self.Bsequence.text()
        for (i, j) in zip(Astr, Bstr):
            Alist.append(int(i))
            Blist.append(int(j))
        F = self.Fexpression.text()
        for (A, B) in zip(Alist, Blist):
            q.append(eval(F))
        print(q)
        num_list_new = [str(x) for x in q]
        re = ",".join(num_list_new)
        self.Csequence.setText(re)

    def paintA(self):
        yA = []
        yB = []
        yC = []
        plt.figure()
        x = np.arange(1, len(Alist), 0.1)
        for i in x:
            if (Alist[int(i)] == 1):
                yA.append(1)
            else:
                yA.append(0)
        for j in x:
            if (Blist[int(j)] == 1):
                yB.append(1)
            else:
                yB.append(0)
        for k in x:
            if (q[int(k)] == 1):
                yC.append(1)
            else:
                yC.append(0)
        ax1 = plt.subplot(221)
        ax1.set_title("A")
        plt.plot(x, yA)
        ax2 = plt.subplot(222)
        ax2.set_title("B")
        plt.plot(x, yB)
        ax3 = plt.subplot(212)
        ax3.set_title("C")
        plt.plot(x, yC)
        plt.show()


if __name__ == "__main__":
    app = QApplication(sys.argv)
    first = initUI()
    first.show()
    sys.exit(app.exec_())